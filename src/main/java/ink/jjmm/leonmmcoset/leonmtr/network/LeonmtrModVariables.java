package ink.jjmm.leonmmcoset.leonmtr.network;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeonmtrModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LeonmtrMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		LeonmtrMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide())
				((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.worldeditcommand = original.worldeditcommand;
			clone.openyourmind = original.openyourmind;
			clone.nbtstring = original.nbtstring;
			clone.nbtstringr1 = original.nbtstringr1;
			clone.blockstring = original.blockstring;
			clone.nbtstringr2 = original.nbtstringr2;
			clone.worldeditcommandr1 = original.worldeditcommandr1;
			clone.worldeditcommandr2 = original.worldeditcommandr2;
			clone.openyourmindr1 = original.openyourmindr1;
			clone.openyourmindr2 = original.openyourmindr2;
			clone.zhixing = original.zhixing;
			clone.run = original.run;
			clone.setpercentageid = original.setpercentageid;
			clone.setpercentagecommand = original.setpercentagecommand;
			clone.join = original.join;
			if (!event.isWasDeath()) {
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "leonmtr_worldvars";
		public String name = "\u94B1\u5E01";
		public String servername = "Leon\u8F68\u9053\u4EA4\u901A";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			name = nbt.getString("name");
			servername = nbt.getString("servername");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("name", name);
			nbt.putString("servername", servername);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "leonmtr_mapvars";
		public double spawnx = 0.0;
		public double spawny = 0.0;
		public double spawnz = 0.0;
		public double tpx = 0.0;
		public double tpy = 0.0;
		public double tpz = 0.0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			spawnx = nbt.getDouble("spawnx");
			spawny = nbt.getDouble("spawny");
			spawnz = nbt.getDouble("spawnz");
			tpx = nbt.getDouble("tpx");
			tpy = nbt.getDouble("tpy");
			tpz = nbt.getDouble("tpz");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putDouble("spawnx", spawnx);
			nbt.putDouble("spawny", spawny);
			nbt.putDouble("spawnz", spawnz);
			nbt.putDouble("tpx", tpx);
			nbt.putDouble("tpy", tpy);
			nbt.putDouble("tpz", tpz);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("leonmtr", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double worldeditcommand = 0.0;
		public double openyourmind = 0;
		public String nbtstring = "\"\"";
		public String nbtstringr1 = "\"\"";
		public String blockstring = "\"\"";
		public String nbtstringr2 = "\"\"";
		public double worldeditcommandr1 = 0.0;
		public double worldeditcommandr2 = 0.0;
		public double openyourmindr1 = 0.0;
		public double openyourmindr2 = 0.0;
		public String zhixing = "";
		public String run = "\"\"";
		public String setpercentageid = "\"\"";
		public String setpercentagecommand = "\"\"";
		public double join = 0.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				LeonmtrMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("worldeditcommand", worldeditcommand);
			nbt.putDouble("openyourmind", openyourmind);
			nbt.putString("nbtstring", nbtstring);
			nbt.putString("nbtstringr1", nbtstringr1);
			nbt.putString("blockstring", blockstring);
			nbt.putString("nbtstringr2", nbtstringr2);
			nbt.putDouble("worldeditcommandr1", worldeditcommandr1);
			nbt.putDouble("worldeditcommandr2", worldeditcommandr2);
			nbt.putDouble("openyourmindr1", openyourmindr1);
			nbt.putDouble("openyourmindr2", openyourmindr2);
			nbt.putString("zhixing", zhixing);
			nbt.putString("run", run);
			nbt.putString("setpercentageid", setpercentageid);
			nbt.putString("setpercentagecommand", setpercentagecommand);
			nbt.putDouble("join", join);
			return nbt;
		}

		public void readNBT(Tag tag) {
			CompoundTag nbt = (CompoundTag) tag;
			worldeditcommand = nbt.getDouble("worldeditcommand");
			openyourmind = nbt.getDouble("openyourmind");
			nbtstring = nbt.getString("nbtstring");
			nbtstringr1 = nbt.getString("nbtstringr1");
			blockstring = nbt.getString("blockstring");
			nbtstringr2 = nbt.getString("nbtstringr2");
			worldeditcommandr1 = nbt.getDouble("worldeditcommandr1");
			worldeditcommandr2 = nbt.getDouble("worldeditcommandr2");
			openyourmindr1 = nbt.getDouble("openyourmindr1");
			openyourmindr2 = nbt.getDouble("openyourmindr2");
			zhixing = nbt.getString("zhixing");
			run = nbt.getString("run");
			setpercentageid = nbt.getString("setpercentageid");
			setpercentagecommand = nbt.getString("setpercentagecommand");
			join = nbt.getDouble("join");
		}
	}

	public static class PlayerVariablesSyncMessage {
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.worldeditcommand = message.data.worldeditcommand;
					variables.openyourmind = message.data.openyourmind;
					variables.nbtstring = message.data.nbtstring;
					variables.nbtstringr1 = message.data.nbtstringr1;
					variables.blockstring = message.data.blockstring;
					variables.nbtstringr2 = message.data.nbtstringr2;
					variables.worldeditcommandr1 = message.data.worldeditcommandr1;
					variables.worldeditcommandr2 = message.data.worldeditcommandr2;
					variables.openyourmindr1 = message.data.openyourmindr1;
					variables.openyourmindr2 = message.data.openyourmindr2;
					variables.zhixing = message.data.zhixing;
					variables.run = message.data.run;
					variables.setpercentageid = message.data.setpercentageid;
					variables.setpercentagecommand = message.data.setpercentagecommand;
					variables.join = message.data.join;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
