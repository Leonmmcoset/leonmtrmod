package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

import io.netty.buffer.Unpooled;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandsetMenu;
import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModItems;

public class AddblocksetProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).worldeditcommand == 1) {
			if (("" + world.getBlockState(BlockPos.containing(x, y, z))).contains("[")) {
				{
					String _setval = ("" + world.getBlockState(BlockPos.containing(x, y, z))).substring((int) (("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("[", 0) + 1),
							("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("]", 0));
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nbtstring = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 1;
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.openyourmind = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(LeonmtrModItems.WORLDEDITADDBLOCK.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Worldeditcommandset");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new WorldeditcommandsetMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
			ItemStack _setstack = (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).copy();
			_setstack.setCount(1);
			((Slot) _slots.get(0)).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}
