package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class MusicdiscproboomProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.JUKEBOX) {
			if ((blockstate.getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp3 && blockstate.getValue(_getbp3)) == true) {
				LeonmtrMod.queueServerWork(890, () -> {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.JUKEBOX) {
						if ((blockstate.getBlock().getStateDefinition().getProperty("has_record") instanceof BooleanProperty _getbp7 && blockstate.getValue(_getbp7)) == true) {
							if (world instanceof Level _level && !_level.isClientSide())
								_level.explode(null, x, y, z, 4, Level.ExplosionInteraction.TNT);
						}
					}
				});
			}
		}
	}
}
