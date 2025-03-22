package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.function.Supplier;
import java.util.Map;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;
import ink.jjmm.leonmmcoset.leonmtr.init.LeonmtrModGameRules;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

public class SetinputProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		LeonmtrMod.queueServerWork(1, () -> {
			if (!((ForgeRegistries.BLOCKS
					.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
							? _bi.getBlock().defaultBlockState()
							: Blocks.AIR.defaultBlockState()).getBlock())
					.toString()).equals("minecraft:air"))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("//set " + (ForgeRegistries.BLOCKS
										.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
												.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()).getBlock())
										.toString())));
					}
				}
				{
					String _setval = "//set " + (ForgeRegistries.BLOCKS.getKey(
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi
									? _bi.getBlock().defaultBlockState()
									: Blocks.AIR.defaultBlockState()).getBlock())
							.toString());
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				LeonmtrMod.queueServerWork(1, () -> {
					if (world.getLevelData().getGameRules().getBoolean(LeonmtrModGameRules.SETKILLITEM)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=item]");
							}
						}
					}
				});
			}
			if (!((ForgeRegistries.BLOCKS
					.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BucketItem _bucket
							? _bucket.getFluid().defaultFluidState().createLegacyBlock()
							: Blocks.AIR.defaultBlockState()).getBlock())
					.toString()).equals("minecraft:air"))) {
				{
					Entity _ent = entity;
					if (!_ent.level().isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level().getServer(), _ent),
								("//set " + (ForgeRegistries.BLOCKS
										.getKey(((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
												.getItem() instanceof BucketItem _bucket ? _bucket.getFluid().defaultFluidState().createLegacyBlock() : Blocks.AIR.defaultBlockState()).getBlock())
										.toString())));
					}
				}
				{
					String _setval = "//set " + (ForgeRegistries.BLOCKS.getKey(
							((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof BucketItem _bucket
									? _bucket.getFluid().defaultFluidState().createLegacyBlock()
									: Blocks.AIR.defaultBlockState()).getBlock())
							.toString());
					entity.getCapability(LeonmtrModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.run = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof Player _player)
					_player.closeContainer();
				LeonmtrMod.queueServerWork(1, () -> {
					if (world.getLevelData().getGameRules().getBoolean(LeonmtrModGameRules.SETKILLITEM)) {
						{
							Entity _ent = entity;
							if (!_ent.level().isClientSide() && _ent.getServer() != null) {
								_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
										_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "kill @e[type=item]");
							}
						}
					}
				});
			}
		});
	}
}
