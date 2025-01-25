package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class LCHelpAdminRunProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("---L\u5E01\u547D\u4EE4\u5E2E\u52A9\uFF08\u7BA1\u7406\u5458\uFF09---"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u5C06\u67D0\u4EBA\u6263\u9664\u4F59\u989D\uFF08/lcpunish <\u54EA\u4E2A\u73A9\u5BB6> <\u6263\u9664\u591A\u5C11\u94B1>\uFF09"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u589E\u52A0\u67D0\u4EBA\u7684\u94B1\u6570\uFF08/lcadd <\u73A9\u5BB6> <\u94B1\u6570>\uFF09"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u67E5\u770B\u67D0\u4EBA\u7684\u94B1\u6570\uFF08/lcsee <\u73A9\u5BB6>\uFF09"), false);
	}
}
