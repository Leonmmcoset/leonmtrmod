package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class LCAddRunProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(3)) {
			{
				Entity _ent = (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity());
				Scoreboard _sc = _ent.level().getScoreboard();
				Objective _so = _sc.getObjective("mtr_balance");
				if (_so == null)
					_so = _sc.addObjective("mtr_balance", ObjectiveCriteria.DUMMY, Component.literal("mtr_balance"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) (new Object() {
					public int getScore(String score, Entity _ent) {
						Scoreboard _sc = _ent.level().getScoreboard();
						Objective _so = _sc.getObjective(score);
						if (_so != null)
							return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
						return 0;
					}
				}.getScore("mtr_balance", (new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity())) + DoubleArgumentType.getDouble(arguments, "number")));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u5DF2\u589E\u52A0\uFF01"), false);
			if ((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity()) instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((entity + "\u7ED9" + "\u4F60" + "\u589E\u52A0\u4E86" + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\u3002")), false);
			LeonmtrMod.LOGGER.info((entity + "\u7ED9" + new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity() + "\u589E\u52A0\u4E86" + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\u3002"));
		}
	}
}
