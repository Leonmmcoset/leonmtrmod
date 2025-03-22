package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import ink.jjmm.leonmmcoset.leonmtr.network.LeonmtrModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SpawnxyzProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity.level().dimension()) == ResourceKey.create(Registries.DIMENSION, new ResourceLocation("leonmtr:joinworld"))) {
			LeonmtrModVariables.MapVariables.get(world).spawnx = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "place").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
			LeonmtrModVariables.MapVariables.get(world).syncData(world);
			LeonmtrModVariables.MapVariables.get(world).spawny = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "place").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
			LeonmtrModVariables.MapVariables.get(world).syncData(world);
			LeonmtrModVariables.MapVariables.get(world).spawnz = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "place").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
			LeonmtrModVariables.MapVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u8BBE\u7F6E\u6210\u529F\uFF01\u5F53\u524Dxyz\u4E3A" + LeonmtrModVariables.MapVariables.get(world).spawnx + "," + LeonmtrModVariables.MapVariables.get(world).spawny + ","
						+ LeonmtrModVariables.MapVariables.get(world).spawnz)), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u60A8\u4E0D\u5728\u52A0\u5165\u4E16\u754C\u7684\u7EF4\u5EA6\u5185"), false);
		}
	}
}
