package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.Checkbox;

import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class SetgoodbyeProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (guistate.containsKey("checkbox:tianchongfangkuainbt") && ((Checkbox) guistate.get("checkbox:tianchongfangkuainbt")).selected()) {
			{
				double _setval = 1;
				entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.worldeditcommand = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			{
				double _setval = 0;
				entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.worldeditcommand = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
