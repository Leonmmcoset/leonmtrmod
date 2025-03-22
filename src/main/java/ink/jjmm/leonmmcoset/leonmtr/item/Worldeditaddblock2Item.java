
package ink.jjmm.leonmmcoset.leonmtr.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import ink.jjmm.leonmmcoset.leonmtr.procedures.Addblockreplace1Procedure;

public class Worldeditaddblock2Item extends Item {
	public Worldeditaddblock2Item() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Addblockreplace1Procedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
