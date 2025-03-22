package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModItems;

public class Addblockreplace1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _stktoremove = new ItemStack(LeonmtrModItems.WORLDEDITADDBLOCK_2.get());
			_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
		}
		{
			String _setval = ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString();
			entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.blockstring = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if ((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).worldeditcommandr1 == 1) {
			if (("" + world.getBlockState(BlockPos.containing(x, y, z))).contains("[")) {
				{
					String _setval = ("" + world.getBlockState(BlockPos.containing(x, y, z))).substring((int) (("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("[", 0) + 1),
							("" + world.getBlockState(BlockPos.containing(x, y, z))).indexOf("]", 0));
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.nbtstringr1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = 1;
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.openyourmindr1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		}
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(LeonmtrModItems.WORLDEDITADDBLOCK_3.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u8BF7\u53F3\u952E\u5C06\u8981\u66FF\u6362\u6210\u7684\u65B9\u5757"), false);
	}
}
