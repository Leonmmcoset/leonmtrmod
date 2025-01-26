package ink.jjmm.leonmmcoset.leonmtr.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.common.Mod;
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
		LeonmtrMod.LOGGER.info("Leon\u8F68\u9053\u4EA4\u901AMod\u52A0\u8F7D\u6210\u529F\uFF01");
	}
}
