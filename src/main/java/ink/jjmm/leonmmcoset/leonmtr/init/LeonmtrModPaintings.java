
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, LeonmtrMod.MODID);
	public static final RegistryObject<PaintingVariant> SERVER_MAP_1 = REGISTRY.register("server_map_1", () -> new PaintingVariant(48, 64));
	public static final RegistryObject<PaintingVariant> SERVER_MAP_B_1 = REGISTRY.register("server_map_b_1", () -> new PaintingVariant(32, 32));
}
