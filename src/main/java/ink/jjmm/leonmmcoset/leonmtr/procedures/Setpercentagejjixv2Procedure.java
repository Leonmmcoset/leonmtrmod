package ink.jjmm.leonmmcoset.leonmtr.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

public class Setpercentagejjixv2Procedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:percentage") ? ((EditBox) guistate.get("text:percentage")).getValue() : "") == 0) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u65E0\u6CD5\u8BC6\u522B\u7684\u6570\u5B57"), false);
		} else {
			if (!((ForgeRegistries.BLOCKS
					.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
							? _bi.getBlock().defaultBlockState()
							: Blocks.AIR.defaultBlockState()).getBlock())
					.toString()).equals("minecraft:air"))) {
				if (((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).setpercentagecommand).isEmpty()) {
					{
						String _setval = "//set " + new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:percentage") ? ((EditBox) guistate.get("text:percentage")).getValue() : "") + "%" + (ForgeRegistries.BLOCKS.getKey(
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
										? _bi.getBlock().defaultBlockState()
										: Blocks.AIR.defaultBlockState()).getBlock())
								.toString());
						entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.setpercentagecommand = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						String _setval = (entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).setpercentagecommand + "," + new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:percentage") ? ((EditBox) guistate.get("text:percentage")).getValue() : "") + "%" + (ForgeRegistries.BLOCKS.getKey(
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
										? _bi.getBlock().defaultBlockState()
										: Blocks.AIR.defaultBlockState()).getBlock())
								.toString());
						entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.setpercentagecommand = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
			if (!((ForgeRegistries.BLOCKS
					.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BucketItem _bucket
							? _bucket.getFluid().defaultFluidState().createLegacyBlock()
							: Blocks.AIR.defaultBlockState()).getBlock())
					.toString()).equals("minecraft:air"))) {
				if (((entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).setpercentagecommand).isEmpty()) {
					{
						String _setval = "//set " + new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:percentage") ? ((EditBox) guistate.get("text:percentage")).getValue() : "") + "%" + (ForgeRegistries.BLOCKS.getKey(
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
										? _bi.getBlock().defaultBlockState()
										: Blocks.AIR.defaultBlockState()).getBlock())
								.toString());
						entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.setpercentagecommand = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					{
						String _setval = (entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new LeonmtrModVariables.PlayerVariables())).setpercentagecommand + "," + new Object() {
							double convert(String s) {
								try {
									return Double.parseDouble(s.trim());
								} catch (Exception e) {
								}
								return 0;
							}
						}.convert(guistate.containsKey("text:percentage") ? ((EditBox) guistate.get("text:percentage")).getValue() : "") + "%" + (ForgeRegistries.BLOCKS.getKey(
								((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
										? _bi.getBlock().defaultBlockState()
										: Blocks.AIR.defaultBlockState()).getBlock())
								.toString());
						entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.setpercentagecommand = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
			}
		}
	}
}
