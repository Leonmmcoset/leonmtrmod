
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

import ink.jjmm.leonmmcoset.leonmtr.block.CxtSaidBlock;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, LeonmtrMod.MODID);
	public static final RegistryObject<Block> CXT_SAID = REGISTRY.register("cxt_said", () -> new CxtSaidBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}
