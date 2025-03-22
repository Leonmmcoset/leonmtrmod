package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class CxtSaidYouJiFangKuaiShiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("CXT\u540D\u8A00\u5927\u8D4F\uFF1A"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u6211\u8BA8\u538C\u5317\u4EAC\u5730\u94C1\u516C\u53F8\uFF0C\u652F\u6301\u4EAC\u6E2F\u5730\u94C1\u516C\u53F8"), false);
	}
}
