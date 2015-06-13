package infi.mods.infiutil.gui;

import infi.mods.infiutil.inventory.ContainerToolbag;
import infi.mods.infiutil.inventory.HeldInventory;
import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack holding = player.getHeldItem();
		if (holding != null && holding.getItem() instanceof ItemToolBag3000) {
			return new ContainerToolbag(player, player.inventory, new HeldInventory(player.getHeldItem(), world.isRemote));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack holding = player.getHeldItem();
		if (holding != null && holding.getItem() instanceof ItemToolBag3000) {
			return new GuiToolbag(new ContainerToolbag(player, player.inventory, new HeldInventory(player.getHeldItem(), world.isRemote)));
		}
		return null;
	}
}
