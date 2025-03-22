package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModItems;

public class ReplaceaddblockProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player)
			_player.closeContainer();
		if (entity instanceof LivingEntity _entity) {
			ItemStack _setstack = new ItemStack(LeonmtrModItems.WORLDEDITADDBLOCK_2.get()).copy();
			_setstack.setCount(1);
			_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
			if (_entity instanceof Player _player)
				_player.getInventory().setChanged();
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u8BF7\u53F3\u952E\u5C06\u8981\u66FF\u6362\u6389\u7684\u65B9\u5757"), false);
	}
}
