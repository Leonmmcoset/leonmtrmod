
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LeonmtrMod.MODID);
	public static final RegistryObject<CreativeModeTab> TAB = REGISTRY.register("tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.leonmtr.tab")).icon(() -> new ItemStack(LeonmtrModBlocks.CXT_SAID.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LeonmtrModBlocks.CXT_SAID.get().asItem());
			})

					.build());
}
