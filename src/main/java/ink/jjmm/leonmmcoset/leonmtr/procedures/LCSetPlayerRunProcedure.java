package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class LCSetPlayerRunProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(4)) {
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
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore((int) DoubleArgumentType.getDouble(arguments, "number"));
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u66F4\u6539\u6210\u529F\uFF01"), false);
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
				_player.displayClientMessage(Component.literal(("\u6700\u9AD8\u6743\u9650\u73A9\u5BB6\u66F4\u6539\u4E86\u4F60\u7684\u94B1\u6570\u4E3A" + DoubleArgumentType.getDouble(arguments, "number") + "\u3002")), false);
			LeonmtrMod.LOGGER.info((entity + "\u66F4\u6539\u4E86" + new Object() {
				public Entity getEntity() {
					try {
						return EntityArgument.getEntity(arguments, "player");
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return null;
					}
				}
			}.getEntity() + "\u7684\u94B1\u6570\u4E3A" + DoubleArgumentType.getDouble(arguments, "number") + "\u3002"));
		}
	}
}
