package ink.jjmm.leonmmcoset.leonmtr.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import ink.jjmm.leonmmcoset.leonmtr.world.inventory.WorldeditcommandreplaceMenu;
import ink.jjmm.leonmmcoset.leonmtr.network.WorldeditcommandreplaceButtonMessage;
import ink.jjmm.leonmmcoset.leonmtr.LeonmtrMod;

import com.mojang.blaze3d.systems.RenderSystem;

public class WorldeditcommandreplaceScreen extends AbstractContainerScreen<WorldeditcommandreplaceMenu> {
	private final static HashMap<String, Object> guistate = WorldeditcommandreplaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox nbt;
	EditBox command;
	EditBox nbt1;
	Checkbox tianchongfangkuainbt;
	Checkbox tianchongfangkuainbt2;
	Button button_zhi_xing_zhi_ling;
	Button button_shua_xin;
	Button button_huo_qu_fang_kuai_shu_ju;

	public WorldeditcommandreplaceScreen(WorldeditcommandreplaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("leonmtr:textures/screens/worldeditcommandreplace.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		nbt.render(guiGraphics, mouseX, mouseY, partialTicks);
		command.render(guiGraphics, mouseX, mouseY, partialTicks);
		nbt1.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (nbt.isFocused())
			return nbt.keyPressed(key, b, c);
		if (command.isFocused())
			return command.keyPressed(key, b, c);
		if (nbt1.isFocused())
			return nbt1.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		nbt.tick();
		command.tick();
		nbt1.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String nbtValue = nbt.getValue();
		String commandValue = command.getValue();
		String nbt1Value = nbt1.getValue();
		super.resize(minecraft, width, height);
		nbt.setValue(nbtValue);
		command.setValue(commandValue);
		nbt1.setValue(nbt1Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.worldeditcommandreplace.label_chuang_shi_shen_fu_zhu_set"), 14, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.worldeditcommandreplace.label_set"), 15, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.worldeditcommandreplace.label_nbt"), 98, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.leonmtr.worldeditcommandreplace.label_nbt1"), 97, 57, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		nbt = new EditBox(this.font, this.leftPos + 126, this.topPos + 26, 70, 18, Component.translatable("gui.leonmtr.worldeditcommandreplace.nbt"));
		nbt.setMaxLength(32767);
		guistate.put("text:nbt", nbt);
		this.addWidget(this.nbt);
		command = new EditBox(this.font, this.leftPos + 70, this.topPos + 82, 126, 18, Component.translatable("gui.leonmtr.worldeditcommandreplace.command"));
		command.setMaxLength(32767);
		guistate.put("text:command", command);
		this.addWidget(this.command);
		nbt1 = new EditBox(this.font, this.leftPos + 126, this.topPos + 53, 70, 18, Component.translatable("gui.leonmtr.worldeditcommandreplace.nbt1"));
		nbt1.setMaxLength(32767);
		guistate.put("text:nbt1", nbt1);
		this.addWidget(this.nbt1);
		button_zhi_xing_zhi_ling = Button.builder(Component.translatable("gui.leonmtr.worldeditcommandreplace.button_zhi_xing_zhi_ling"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new WorldeditcommandreplaceButtonMessage(0, x, y, z));
				WorldeditcommandreplaceButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 81, 41, 20).build();
		guistate.put("button:button_zhi_xing_zhi_ling", button_zhi_xing_zhi_ling);
		this.addRenderableWidget(button_zhi_xing_zhi_ling);
		button_shua_xin = Button.builder(Component.translatable("gui.leonmtr.worldeditcommandreplace.button_shua_xin"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new WorldeditcommandreplaceButtonMessage(1, x, y, z));
				WorldeditcommandreplaceButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 243, this.topPos + 116, 42, 20).build();
		guistate.put("button:button_shua_xin", button_shua_xin);
		this.addRenderableWidget(button_shua_xin);
		button_huo_qu_fang_kuai_shu_ju = Button.builder(Component.translatable("gui.leonmtr.worldeditcommandreplace.button_huo_qu_fang_kuai_shu_ju"), e -> {
			if (true) {
				LeonmtrMod.PACKET_HANDLER.sendToServer(new WorldeditcommandreplaceButtonMessage(2, x, y, z));
				WorldeditcommandreplaceButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 211, this.topPos + 82, 74, 20).build();
		guistate.put("button:button_huo_qu_fang_kuai_shu_ju", button_huo_qu_fang_kuai_shu_ju);
		this.addRenderableWidget(button_huo_qu_fang_kuai_shu_ju);
		tianchongfangkuainbt = new Checkbox(this.leftPos + 211, this.topPos + 25, 20, 20, Component.translatable("gui.leonmtr.worldeditcommandreplace.tianchongfangkuainbt"), false);
		guistate.put("checkbox:tianchongfangkuainbt", tianchongfangkuainbt);
		this.addRenderableWidget(tianchongfangkuainbt);
		tianchongfangkuainbt2 = new Checkbox(this.leftPos + 211, this.topPos + 52, 20, 20, Component.translatable("gui.leonmtr.worldeditcommandreplace.tianchongfangkuainbt2"), false);
		guistate.put("checkbox:tianchongfangkuainbt2", tianchongfangkuainbt2);
		this.addRenderableWidget(tianchongfangkuainbt2);
	}
}
