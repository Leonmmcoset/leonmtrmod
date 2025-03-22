
package ink.jjmm.leonmmcoset.leonmtr.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResult;
import net.minecraft.resources.ResourceLocation;

import ink.jjmm.leonmmcoset.leonmtr.procedures.MusicdiscproboomplayerProcedure;
import ink.jjmm.leonmmcoset.leonmtr.procedures.MusicdiscproboomProcedure;

public class MusicdiscproItem extends RecordItem {
	public MusicdiscproItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("leonmtr:roundabout")), new Item.Properties().stacksTo(1).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(-4).saturationMod(0.5f).meat().build()),
				10200);
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		MusicdiscproboomplayerProcedure.execute(world, x, y, z);
		return retval;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MusicdiscproboomProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()));
		return InteractionResult.SUCCESS;
	}
}
