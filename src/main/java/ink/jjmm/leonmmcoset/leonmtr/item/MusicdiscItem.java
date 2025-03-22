
package ink.jjmm.leonmmcoset.leonmtr.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class MusicdiscItem extends RecordItem {
	public MusicdiscItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("leonmtr:bloody_mary_x_dom_dom")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC), 4600);
	}
}
