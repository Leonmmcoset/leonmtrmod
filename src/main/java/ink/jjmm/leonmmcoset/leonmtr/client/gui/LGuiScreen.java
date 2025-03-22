package ink.jjmm.leonmmcoset.leonmtr.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.LGuiMenu;
import ink.jjmm.leonmmcoset.leonmtr.network.LGuiButtonMessage;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class LGuiScreen extends AbstractContainerScreen<LGuiMenu> {
	private final static HashMap<String, Object> guistate = LGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_give_me_night_version;
	Button button_exit;
	Button button_qing_chu_diao_luo_wu;

	public LGuiScreen(LGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("leonmtr:textures/screens/l_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.l_gui.label_fast_command_menu"), 62, 15, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_give_me_night_version = Button.builder(Component.translatable("gui.leonmtr.l_gui.button_give_me_night_version"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new LGuiButtonMessage(0, x, y, z));
				LGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 20, this.topPos + 38, 134, 20).build();
		guistate.put("button:button_give_me_night_version", button_give_me_night_version);
		this.addRenderableWidget(button_give_me_night_version);
		button_exit = Button.builder(Component.translatable("gui.leonmtr.l_gui.button_exit"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new LGuiButtonMessage(1, x, y, z));
				LGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 134, 46, 20).build();
		guistate.put("button:button_exit", button_exit);
		this.addRenderableWidget(button_exit);
		button_qing_chu_diao_luo_wu = Button.builder(Component.translatable("gui.leonmtr.l_gui.button_qing_chu_diao_luo_wu"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new LGuiButtonMessage(2, x, y, z));
				LGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 20, this.topPos + 82, 134, 20).build();
		guistate.put("button:button_qing_chu_diao_luo_wu", button_qing_chu_diao_luo_wu);
		this.addRenderableWidget(button_qing_chu_diao_luo_wu);
	}
}
