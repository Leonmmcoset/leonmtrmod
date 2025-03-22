package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class LCHelpRunProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("---" + LeonmtrModVariables.WorldVariables.get(world).name + "\u547D\u4EE4\u5E2E\u52A9---")), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u8BFB\u53D6\u81EA\u5DF1\u7684MTR\u4F59\u989D\u5E76\u663E\u793A\u51FA\u6765\uFF08/lc get\uFF09"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u5C06\u81EA\u5DF1\u7684\u4F59\u989D\u652F\u4ED8\u7ED9\u5176\u4ED6\u4EBA\uFF08/lc pay <\u652F\u4ED8\u7ED9\u54EA\u4E2A\u73A9\u5BB6> <\u591A\u5C11\u94B1>\uFF09"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u6253\u5F00LGui\uFF08/lgui\uFF09"), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u5982\u679C\u4F60\u662F\u670D\u52A1\u5668\u7BA1\u7406\u5458\uFF0C\u8BF7\u8F93\u5165\u547D\u4EE4/lc helpadmin\u3002"), false);
	}
}
