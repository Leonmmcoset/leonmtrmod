
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraft.world.inventory.MenuType;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.LGuiMenu;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, LeonmtrMod.MODID);
	public static final RegistryObject<MenuType<LGuiMenu>> L_GUI = REGISTRY.register("l_gui", () -> IForgeMenuType.create(LGuiMenu::new));
}
