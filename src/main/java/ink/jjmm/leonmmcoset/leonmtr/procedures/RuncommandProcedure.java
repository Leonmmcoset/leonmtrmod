package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModGameRules;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class RuncommandProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).run).isEmpty()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u6CA1\u6709\u751F\u6210\u7684\u6307\u4EE4"), false);
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), ((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).run));
				}
			}
			LeonmtrMod.queueServerWork(1, () -> {
				if (world.getLevelData().getGameRules().getBoolean(LeonmtrModGameRules.SETKILLITEM)) {
					{
						Entity _ent = entity;
						if (!_ent.level().isClientSide() && _ent.getServer() != null) {
							_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
									_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=item]");
						}
					}
				}
			});
		}
	}
}
