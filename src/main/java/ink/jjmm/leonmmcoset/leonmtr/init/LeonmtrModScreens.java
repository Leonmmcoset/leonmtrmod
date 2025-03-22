
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import ink.jjmm.leonmmcoset.leonmtr.client.gui.WorldeditcommandsetScreen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.WorldeditcommandreplaceScreen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.WorldeditcommandGUIScreen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.SetguiScreen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.PercentageScreen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.Percentage2Screen;
import ink.jjmm.leonmmcoset.leonmtr.client.gui.LGuiScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class LeonmtrModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(LeonmtrModMenus.L_GUI.get(), LGuiScreen::new);
			MenuScreens.register(LeonmtrModMenus.WORLDEDITCOMMAND_GUI.get(), WorldeditcommandGUIScreen::new);
			MenuScreens.register(LeonmtrModMenus.WORLDEDITCOMMANDSET.get(), WorldeditcommandsetScreen::new);
			MenuScreens.register(LeonmtrModMenus.WORLDEDITCOMMANDREPLACE.get(), WorldeditcommandreplaceScreen::new);
			MenuScreens.register(LeonmtrModMenus.SETGUI.get(), SetguiScreen::new);
			MenuScreens.register(LeonmtrModMenus.PERCENTAGE.get(), PercentageScreen::new);
			MenuScreens.register(LeonmtrModMenus.PERCENTAGE_2.get(), Percentage2Screen::new);
		});
	}
}
