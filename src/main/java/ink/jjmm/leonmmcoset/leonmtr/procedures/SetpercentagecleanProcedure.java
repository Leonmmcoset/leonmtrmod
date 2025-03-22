package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.Entity;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class SetpercentagecleanProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "";
			entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.setpercentagecommand = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
