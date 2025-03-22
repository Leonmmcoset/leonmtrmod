package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.Entity;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class PpProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = 0;
			entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.join = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
