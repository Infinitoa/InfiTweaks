package infi.mods.infiutil.gui;

import infi.mods.infiutil.inventory.ContainerToolbag;
import infi.mods.infiutil.inventory.HeldInventory;
import infi.mods.infiutil.ref.References;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiToolbag extends GuiContainer {

	private static final ResourceLocation guiTexture = new ResourceLocation(References.MOD_ID, "/textures/gui/gui_toolBag3000.png");
	private HeldInventory inventoryBag;

	public GuiToolbag(ContainerToolbag container) {
		super(container);
		this.inventoryBag = container.inventoryBag;
		xSize = 176;
		ySize = 168;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
		Minecraft.getMinecraft().renderEngine.bindTexture(guiTexture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
}
