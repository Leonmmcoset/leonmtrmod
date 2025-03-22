package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class AddblockreplacerProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		LeonmtrMod.queueServerWork(1, () -> {
			if ((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).openyourmindr1 == 1) {
				if (guistate.get("text:nbt") instanceof EditBox _tf)
					_tf.setValue(((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).nbtstringr1));
				{
					double _setval = 0;
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.openyourmindr1 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
			if ((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).openyourmindr2 == 1) {
				if (guistate.get("text:nbt1") instanceof EditBox _tf)
					_tf.setValue(((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).nbtstringr2));
				{
					double _setval = 0;
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.openyourmindr2 = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
			}
		});
	}
}
