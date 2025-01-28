package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.api.distmarker.Dist;

import javax.annotation.Nullable;

import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.DEDICATED_SERVER})
public class ModStartServerProcedure {
	@SubscribeEvent
	public static void init(FMLDedicatedServerSetupEvent event) {
		execute();
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
		LeonmtrMod.LOGGER.info("---Leon\u8F68\u9053\u4EA4\u901AMod---");
		LeonmtrMod.LOGGER.info("\u4F5C\u8005\uFF1ALeonMMcoset");
		if (ModList.get().isLoaded("mtr")) {
			LeonmtrMod.LOGGER.info("\u670D\u52A1\u5668\u5DF2\u52A0\u8F7DMTR Mod\uFF01");
		} else {
			LeonmtrMod.LOGGER.warn("\u670D\u52A1\u5668\u6CA1\u6709\u52A0\u8F7DMTR Mod\uFF0C\u5927\u591A\u6570\u529F\u80FD\u5C06\u65E0\u6CD5\u4F7F\u7528\uFF01");
		}
		LeonmtrMod.LOGGER.info("Leon\u8F68\u9053\u4EA4\u901AMod\u52A0\u8F7D\u6210\u529F\uFF01");
	}
}
