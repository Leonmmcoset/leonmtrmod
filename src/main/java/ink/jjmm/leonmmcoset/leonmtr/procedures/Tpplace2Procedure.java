package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class Tpplace2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			if (!_ent.level().isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level().getServer(), _ent),
						("execute in leonmtr:joinworld run tp " + LeonmtrModVariables.MapVariables.get(world).tpx + " " + LeonmtrModVariables.MapVariables.get(world).tpy + " " + LeonmtrModVariables.MapVariables.get(world).tpz));
			}
		}
	}
}
