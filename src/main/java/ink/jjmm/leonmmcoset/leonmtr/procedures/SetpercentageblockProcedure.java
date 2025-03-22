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
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.PercentageMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.Percentage2Menu;
import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class SetpercentageblockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Percentage2");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new Percentage2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		} else {
			if (("" + world.getBlockState(BlockPos.containing(x, y, z))).contains("[")) {
				{
					String _setval = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString() + "" + ("" + world.getBlockState(BlockPos.containing(x, y, z)))
							.substring(("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("[", 0), (int) (("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("]", 0) + 1));
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.setpercentageid = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			} else {
				{
					String _setval = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString();
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.setpercentageid = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Percentage");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new PercentageMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
