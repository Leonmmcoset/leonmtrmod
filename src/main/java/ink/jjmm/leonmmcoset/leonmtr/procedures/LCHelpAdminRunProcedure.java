package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class LCHelpAdminRunProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(3)) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("---" + LeonmtrModVariables.WorldVariables.get(world).name + "\u547D\u4EE4\u5E2E\u52A9\uFF08\u7BA1\u7406\u5458\uFF09---")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u5C06\u67D0\u4EBA\u6263\u9664\u4F59\u989D\uFF08/lc punish <\u54EA\u4E2A\u73A9\u5BB6> <\u6263\u9664\u591A\u5C11\u94B1>\uFF09"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u589E\u52A0\u67D0\u4EBA\u7684\u94B1\u6570\uFF08/lc add <\u73A9\u5BB6> <\u94B1\u6570>\uFF09"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u67E5\u770B\u67D0\u4EBA\u7684\u94B1\u6570\uFF08/lc see <\u73A9\u5BB6>\uFF09"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uFF08\u6743\u9650\u7B49\u7EA74\uFF09\u8BBE\u7F6E\u67D0\u4EBA\u7684\u94B1\u6570\uFF08/lc set <\u73A9\u5BB6> <\u94B1\u6570>\uFF09"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uFF08\u6743\u9650\u7B49\u7EA74\uFF09\u63D0\u793A\u670D\u52A1\u5668\u6240\u6709\u4EBA\u8981\u5173\u95ED\u670D\u52A1\u5668\u4E86\uFF08/server stopsay <\u539F\u56E0>\uFF09"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\uFF08\u6743\u9650\u7B49\u7EA74\uFF09\u53D1\u9001\u670D\u52A1\u5668\u516C\u544A\uFF08/server say <\u516C\u544A\u5185\u5BB9>\uFF09"), false);
		}
	}
}
