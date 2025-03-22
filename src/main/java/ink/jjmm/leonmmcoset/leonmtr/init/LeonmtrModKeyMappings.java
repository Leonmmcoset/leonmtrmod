
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package ink.jjmm.leonmmcoset.leonmtr.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import ink.jjmm.leonmmcoset.leonmtr.network.LguianjianMessage;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class LeonmtrModKeyMappings {
	public static final KeyMapping LGUIANJIAN = new KeyMapping("key.leonmtr.lguianjian", GLFW.GLFW_KEY_G, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new LguianjianMessage(0, 0));
				LguianjianMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(LGUIANJIAN);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				LGUIANJIAN.consumeClick();
			}
		}
	}
}
