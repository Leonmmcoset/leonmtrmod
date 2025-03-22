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

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandGUIMenu;
import ink.jjmm.leonmmcoset.leonmtr.network.WorldeditcommandGUIButtonMessage;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class WorldeditcommandGUIScreen extends AbstractContainerScreen<WorldeditcommandGUIMenu> {
	private final static HashMap<String, Object> guistate = WorldeditcommandGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_she_zhi_fang_kuai;
	Button button_ti_huan_fang_kuai;

	public WorldeditcommandGUIScreen(WorldeditcommandGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("leonmtr:textures/screens/worldeditcommand_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.worldeditcommand_gui.label_chuang_shi_shen_fu_zhu_ye_mian"), 56, 19, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_she_zhi_fang_kuai = Button.builder(Component.translatable("gui.leonmtr.worldeditcommand_gui.button_she_zhi_fang_kuai"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new WorldeditcommandGUIButtonMessage(0, x, y, z));
				WorldeditcommandGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 23, this.topPos + 44, 128, 20).build();
		guistate.put("button:button_she_zhi_fang_kuai", button_she_zhi_fang_kuai);
		this.addRenderableWidget(button_she_zhi_fang_kuai);
		button_ti_huan_fang_kuai = Button.builder(Component.translatable("gui.leonmtr.worldeditcommand_gui.button_ti_huan_fang_kuai"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new WorldeditcommandGUIButtonMessage(1, x, y, z));
				WorldeditcommandGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 23, this.topPos + 84, 128, 20).build();
		guistate.put("button:button_ti_huan_fang_kuai", button_ti_huan_fang_kuai);
		this.addRenderableWidget(button_ti_huan_fang_kuai);
	}
}
