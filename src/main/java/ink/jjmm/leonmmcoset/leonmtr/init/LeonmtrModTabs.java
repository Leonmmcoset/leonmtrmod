
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class LeonmtrModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LeonmtrMod.MODID);
	public static final RegistryObject<CreativeModeTab> TAB = REGISTRY.register("tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.leonmtr.tab")).icon(() -> new ItemStack(LeonmtrModItems.LEONLOGO.get())).displayItems((parameters, tabData) -> {
				tabData.accept(LeonmtrModBlocks.CXT_SAID.get().asItem());
			}).build());
	public static final RegistryObject<CreativeModeTab> WORLDEDITCOMMANDTAB = REGISTRY.register("worldeditcommandtab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.leonmtr.worldeditcommandtab")).icon(() -> new ItemStack(Items.WOODEN_AXE)).displayItems((parameters, tabData) -> {
				tabData.accept(LeonmtrModItems.SET.get());
				tabData.accept(LeonmtrModItems.RUN.get());
			}).withSearchBar().withTabsBefore(TAB.getId()).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(LeonmtrModItems.MUSICDISC.get());
		}
	}
}
