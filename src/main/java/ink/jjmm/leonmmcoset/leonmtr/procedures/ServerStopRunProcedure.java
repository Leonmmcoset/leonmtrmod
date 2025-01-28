package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class ServerStopRunProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments) {
		for (int index0 = 0; index0 < 3; index0++) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("leonmtr:alarm")), SoundSource.VOICE, 5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("leonmtr:alarm")), SoundSource.VOICE, 5, 1, false);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"title @a title \u670D\u52A1\u5668\u8981\u5173\u95ED\u5566\uFF01\uFF01\uFF01\"");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("title @a subtitle \"\u539F\u56E0\uFF1A" + "" + (new Object() {
							public String getMessage() {
								try {
									return MessageArgument.getMessage(arguments, "reason").getString();
								} catch (CommandSyntaxException ignored) {
									return "";
								}
							}
						}).getMessage() + "\""));
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal(("\u670D\u52A1\u5668\u8981\u5173\u95ED\u5566\uFF01\u539F\u56E0\uFF1A" + (new Object() {
					public String getMessage() {
						try {
							return MessageArgument.getMessage(arguments, "reason").getString();
						} catch (CommandSyntaxException ignored) {
							return "";
						}
					}
				}).getMessage() + "\u3002")), false);
			LeonmtrMod.LOGGER.info(("\u670D\u52A1\u5668\u8981\u5173\u95ED\u5566\uFF01\u539F\u56E0\uFF1A" + (new Object() {
				public String getMessage() {
					try {
						return MessageArgument.getMessage(arguments, "reason").getString();
					} catch (CommandSyntaxException ignored) {
						return "";
					}
				}
			}).getMessage() + "\u3002"));
		}
		LeonmtrMod.LOGGER.info("\u62A5\u544A\u5B8C\u6210\u3002");
	}
}
