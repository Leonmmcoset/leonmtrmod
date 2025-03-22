
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeonmtrModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> SETKILLITEM = GameRules.register("setkillitem", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> STOPJOIN = GameRules.register("stopjoin", GameRules.Category.SPAWNING, GameRules.BooleanValue.create(true));
}
