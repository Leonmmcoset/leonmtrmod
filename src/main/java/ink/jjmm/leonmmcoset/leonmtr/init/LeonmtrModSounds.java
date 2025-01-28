
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, LeonmtrMod.MODID);
	public static final RegistryObject<SoundEvent> ALARM = REGISTRY.register("alarm", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("leonmtr", "alarm")));
	public static final RegistryObject<SoundEvent> NOTICE = REGISTRY.register("notice", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("leonmtr", "notice")));
}
