
package ink.jjmm.leonmmcoset.leonmtr.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandsetMenu;
import ink.jjmm.leonmmcoset.leonmtr.procedures.SetcommandProcedure;
import ink.jjmm.leonmmcoset.leonmtr.procedures.SetaddblockProcedure;
import ink.jjmm.leonmmcoset.leonmtr.procedures.RunsetcommandProcedure;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WorldeditcommandsetButtonMessage {
	private final int buttonID, x, y, z;

	public WorldeditcommandsetButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WorldeditcommandsetButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WorldeditcommandsetButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WorldeditcommandsetButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = WorldeditcommandsetMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			RunsetcommandProcedure.execute(entity, guistate);
		}
		if (buttonID == 1) {

			SetcommandProcedure.execute(entity, guistate);
		}
		if (buttonID == 2) {

			SetaddblockProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		LeonmtrMod.addNetworkMessage(WorldeditcommandsetButtonMessage.class, WorldeditcommandsetButtonMessage::buffer, WorldeditcommandsetButtonMessage::new, WorldeditcommandsetButtonMessage::handler);
	}
}
