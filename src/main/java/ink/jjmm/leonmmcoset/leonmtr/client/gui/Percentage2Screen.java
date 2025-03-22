package ink.jjmm.leonmmcoset.leonmtr.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.Percentage2Menu;
import ink.jjmm.leonmmcoset.leonmtr.network.Percentage2ButtonMessage;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class Percentage2Screen extends AbstractContainerScreen<Percentage2Menu> {
	private final static HashMap<String, Object> guistate = Percentage2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox percentage;
	Button button_ji_xu;
	Button button_wan_cheng;
	Button button_qing_chu;

	public Percentage2Screen(Percentage2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 175;
		this.imageHeight = 180;
	}

	private static final ResourceLocation texture = new ResourceLocation("leonmtr:textures/screens/percentage_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		percentage.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (percentage.isFocused())
			return percentage.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		percentage.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String percentageValue = percentage.getValue();
		super.resize(minecraft, width, height);
		percentage.setValue(percentageValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.percentage_2.label_zhan_bi_bai_fen_bi"), 60, 17, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.percentage_2.label_empty"), 116, 40, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		percentage = new EditBox(this.font, this.leftPos + 84, this.topPos + 37, 25, 18, Component.translatable("gui.leonmtr.percentage_2.percentage")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.leonmtr.percentage_2.percentage").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.leonmtr.percentage_2.percentage").getString());
				else
					setSuggestion(null);
			}
		};
		percentage.setSuggestion(Component.translatable("gui.leonmtr.percentage_2.percentage").getString());
		percentage.setMaxLength(32767);
		guistate.put("text:percentage", percentage);
		this.addWidget(this.percentage);
		button_ji_xu = Button.builder(Component.translatable("gui.leonmtr.percentage_2.button_ji_xu"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new Percentage2ButtonMessage(0, x, y, z));
				Percentage2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 66, 54, 20).build();
		guistate.put("button:button_ji_xu", button_ji_xu);
		this.addRenderableWidget(button_ji_xu);
		button_wan_cheng = Button.builder(Component.translatable("gui.leonmtr.percentage_2.button_wan_cheng"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new Percentage2ButtonMessage(1, x, y, z));
				Percentage2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 69, this.topPos + 66, 65, 20).build();
		guistate.put("button:button_wan_cheng", button_wan_cheng);
		this.addRenderableWidget(button_wan_cheng);
		button_qing_chu = Button.builder(Component.translatable("gui.leonmtr.percentage_2.button_qing_chu"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new Percentage2ButtonMessage(2, x, y, z));
				Percentage2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 66, 25, 20).build();
		guistate.put("button:button_qing_chu", button_qing_chu);
		this.addRenderableWidget(button_qing_chu);
	}
}
