
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import ink.jjmm.leonmmcoset.leonmtr.item.ZhixingItem;
import ink.jjmm.leonmmcoset.leonmtr.item.WorldeditcommandItem;
import ink.jjmm.leonmmcoset.leonmtr.item.WorldeditaddblockItem;
import ink.jjmm.leonmmcoset.leonmtr.item.Worldeditaddblock3Item;
import ink.jjmm.leonmmcoset.leonmtr.item.Worldeditaddblock2Item;
import ink.jjmm.leonmmcoset.leonmtr.item.SetpercentageItem;
import ink.jjmm.leonmmcoset.leonmtr.item.SetItem;
import ink.jjmm.leonmmcoset.leonmtr.item.RunItem;
import ink.jjmm.leonmmcoset.leonmtr.item.MusicdiscproItem;
import ink.jjmm.leonmmcoset.leonmtr.item.MusicdiscItem;
import ink.jjmm.leonmmcoset.leonmtr.item.LeonlogoItem;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class LeonmtrModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, LeonmtrMod.MODID);
	public static final RegistryObject<Item> CXT_SAID = block(LeonmtrModBlocks.CXT_SAID);
	public static final RegistryObject<Item> MUSICDISC = REGISTRY.register("musicdisc", () -> new MusicdiscItem());
	public static final RegistryObject<Item> WORLDEDITCOMMAND = REGISTRY.register("worldeditcommand", () -> new WorldeditcommandItem());
	public static final RegistryObject<Item> MUSICDISCPRO = REGISTRY.register("musicdiscpro", () -> new MusicdiscproItem());
	public static final RegistryObject<Item> WORLDEDITADDBLOCK = REGISTRY.register("worldeditaddblock", () -> new WorldeditaddblockItem());
	public static final RegistryObject<Item> WORLDEDITADDBLOCK_2 = REGISTRY.register("worldeditaddblock_2", () -> new Worldeditaddblock2Item());
	public static final RegistryObject<Item> WORLDEDITADDBLOCK_3 = REGISTRY.register("worldeditaddblock_3", () -> new Worldeditaddblock3Item());
	public static final RegistryObject<Item> ZHIXING = REGISTRY.register("zhixing", () -> new ZhixingItem());
	public static final RegistryObject<Item> SET = REGISTRY.register("set", () -> new SetItem());
	public static final RegistryObject<Item> RUN = REGISTRY.register("run", () -> new RunItem());
	public static final RegistryObject<Item> LEONLOGO = REGISTRY.register("leonlogo", () -> new LeonlogoItem());
	public static final RegistryObject<Item> SETPERCENTAGE = REGISTRY.register("setpercentage", () -> new SetpercentageItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}
