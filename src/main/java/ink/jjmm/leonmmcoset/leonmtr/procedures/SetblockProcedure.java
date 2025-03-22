package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import io.netty.buffer.Unpooled;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.SetguiMenu;
import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModGameRules;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class SetblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Setgui");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new SetguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if (("" + world.getBlockState(BlockPos.containing(x, y, z))).contains("[")) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("//set " + ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString() + ("" + world.getBlockState(BlockPos.containing(x, y, z)))
										.substring(("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("[", 0), (int) (("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("]", 0) + 1))));
					}
				}
				{
					String _setval = "//set " + ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString() + ("" + world.getBlockState(BlockPos.containing(x, y, z)))
							.substring(("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("[", 0), (int) (("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("]", 0) + 1));
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
								_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ("//set " + ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()));
					}
				}
				{
					String _setval = "//set " + ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString();
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			LeonmtrMod.queueServerWork(1, () -> {
				if (world.getLevelData().getGameRules().getBoolean(LeonmtrModGameRules.SETKILLITEM)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=item]");
						}
					}
				}
			});
		}
	}
}
