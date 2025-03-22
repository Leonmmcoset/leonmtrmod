
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandsetMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandreplaceMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandGUIMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.SetguiMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.PercentageMenu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.Percentage2Menu;
import ink.jjmm.leonmmcoset.leonmtr.world.inventory.LGuiMenu;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LeonmtrMod.MODID);
	public static final RegistryObject<MenuType<LGuiMenu>> L_GUI = REGISTRY.register("l_gui", () -> IForgeMenuType.create(LGuiMenu::new));
	public static final RegistryObject<MenuType<WorldeditcommandGUIMenu>> WORLDEDITCOMMAND_GUI = REGISTRY.register("worldeditcommand_gui", () -> IForgeMenuType.create(WorldeditcommandGUIMenu::new));
	public static final RegistryObject<MenuType<WorldeditcommandsetMenu>> WORLDEDITCOMMANDSET = REGISTRY.register("worldeditcommandset", () -> IForgeMenuType.create(WorldeditcommandsetMenu::new));
	public static final RegistryObject<MenuType<WorldeditcommandreplaceMenu>> WORLDEDITCOMMANDREPLACE = REGISTRY.register("worldeditcommandreplace", () -> IForgeMenuType.create(WorldeditcommandreplaceMenu::new));
	public static final RegistryObject<MenuType<SetguiMenu>> SETGUI = REGISTRY.register("setgui", () -> IForgeMenuType.create(SetguiMenu::new));
	public static final RegistryObject<MenuType<PercentageMenu>> PERCENTAGE = REGISTRY.register("percentage", () -> IForgeMenuType.create(PercentageMenu::new));
	public static final RegistryObject<MenuType<Percentage2Menu>> PERCENTAGE_2 = REGISTRY.register("percentage_2", () -> IForgeMenuType.create(Percentage2Menu::new));
}
