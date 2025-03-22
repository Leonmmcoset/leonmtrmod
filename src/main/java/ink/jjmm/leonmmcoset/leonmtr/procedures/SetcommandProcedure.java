package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class SetcommandProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if ((guistate.containsKey("text:nbt") ? ((EditBox) guistate.get("text:nbt")).getValue() : "").isEmpty()) {
			if (guistate.get("text:command") instanceof EditBox _tf)
				_tf.setValue(("//set " + (ForgeRegistries.ITEMS
						.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString())));
			{
				String _setval = "//set " + (ForgeRegistries.ITEMS
						.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString());
				entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.zhixing = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (guistate.get("text:command") instanceof EditBox _tf)
				_tf.setValue(("//set " + (ForgeRegistries.ITEMS
						.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString()) + "["
						+ (guistate.containsKey("text:nbt") ? ((EditBox) guistate.get("text:nbt")).getValue() : "") + "]"));
			{
				String _setval = "//set " + (ForgeRegistries.ITEMS
						.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem()).toString()) + "["
						+ (guistate.containsKey("text:nbt") ? ((EditBox) guistate.get("text:nbt")).getValue() : "") + "]";
				entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.zhixing = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal("\u751F\u6210\u6210\u529F\uFF01\u53EF\u4F7F\u7528\u6267\u884C\u5237\u6267\u884C\u547D\u4EE4"), false);
	}
}
