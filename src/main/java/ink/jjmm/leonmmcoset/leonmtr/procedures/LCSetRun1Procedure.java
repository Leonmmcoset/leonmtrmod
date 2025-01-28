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

public class LCSetRun1Procedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (DoubleArgumentType.getDouble(arguments, "number") > 0) {
			if (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.level().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("mtr_balance", entity) < DoubleArgumentType.getDouble(arguments, "number")) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u4F60\u6CA1\u90A3\u94B1\uFF01\uFF08\u4EBA\u8BDD\uFF1A\u4F59\u989D\u4E0D\u8DB3\uFF09"), false);
			} else {
				{
					Entity _ent = entity;
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
					}.getScore("mtr_balance", entity) - DoubleArgumentType.getDouble(arguments, "number")));
				}
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
					_player.displayClientMessage(Component.literal(("\u4F60\u652F\u4ED8\u7ED9" + new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity() + " " + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\u3002")), false);
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
					_player.displayClientMessage(Component.literal((new Object() {
						public Entity getEntity() {
							try {
								return EntityArgument.getEntity(arguments, "player");
							} catch (CommandSyntaxException e) {
								e.printStackTrace();
								return null;
							}
						}
					}.getEntity() + "\u652F\u4ED8\u7ED9\u4F60" + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\u3002")), false);
				LeonmtrMod.LOGGER.info((entity + "\u652F\u4ED8\u7ED9" + new Object() {
					public Entity getEntity() {
						try {
							return EntityArgument.getEntity(arguments, "player");
						} catch (CommandSyntaxException e) {
							e.printStackTrace();
							return null;
						}
					}
				}.getEntity() + " " + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\u3002"));
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u54CE\u5440\uFF0C\u522B\u60F3\u73A9\u8FD9\u4E2ABug\u4E86\uFF01\uFF08\u4EBA\u8BDD\uFF1A\u8BF7\u8F93\u5165\u6B63\u6570\uFF09"), false);
		}
	}
}
