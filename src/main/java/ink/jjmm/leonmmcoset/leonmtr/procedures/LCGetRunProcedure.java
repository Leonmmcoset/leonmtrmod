package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class LCGetRunProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u60A8\u7684" + LeonmtrModVariables.WorldVariables.get(world).name + "\u4F59\u989D\u662F\uFF1A" + (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("mtr_balance", entity)) + "\u3002")), false);
	}
}
