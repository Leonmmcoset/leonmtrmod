package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class LCSetRun2Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u4E0D\u597D\u610F\u601D\uFF0C\u547D\u4EE4\u51FA\u9519\uFF01"), false);
	}
}
