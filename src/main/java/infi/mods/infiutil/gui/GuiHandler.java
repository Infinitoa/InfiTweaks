package infi.mods.infiutil.gui;

import infi.mods.infiutil.InfiUtilities;
import infi.mods.infiutil.inventory.ContainerToolbag;
import infi.mods.infiutil.inventory.HeldInventory;
import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

	public GuiHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(InfiUtilities.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack holding = player.getHeldItem();
		if (holding != null && holding.getItem() instanceof ItemToolBag3000) {
			return new ContainerToolbag(player, player.inventory, new HeldInventory(player.getHeldItem(), player.worldObj));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack holding = player.getHeldItem();
		if (holding != null && holding.getItem() instanceof ItemToolBag3000) {
			return new GuiToolbag(new ContainerToolbag(player, player.inventory, new HeldInventory(player.getHeldItem(), player.worldObj)));
		}
		return null;

	}

}
