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

public class LCPunishRunProcedure {
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
				}.getEntity())) - DoubleArgumentType.getDouble(arguments, "number")));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u6263\u9664\u6210\u529F\uFF01"), false);
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
				_player.displayClientMessage(Component.literal(("\u4F60\u56E0\u4E3A\u8FDD\u53CD\u4E86\u89C4\u5219\u88AB\u6263\u9664" + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name
						+ "\uFF0C\u5982\u6709\u5F02\u8BAE\uFF0C\u8BF7\u5728\u8BBA\u575B\u6C42\u52A9\uFF0C\u5E76\u76F4\u63A5@\u670D\u4E3B\uFF08LeonMMcoset\uFF09\uFF01")), false);
			LeonmtrMod.LOGGER.info((new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity() + "\u8FDD\u53CD\u4E86\u89C4\u5219\u88AB\u6263\u9664" + DoubleArgumentType.getDouble(arguments, "number") + LeonmtrModVariables.WorldVariables.get(world).name + "\uFF0C\u6267\u884C\u8005\uFF1A" + entity + "\u3002"));
		}
	}
}
