package infi.mods.infiutil.proxies;

import infi.mods.infiutil.gui.GuiToolbag;
import infi.mods.infiutil.inventory.ContainerToolbag;
import infi.mods.infiutil.inventory.HeldInventory;
import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		ItemStack holding = player.getHeldItem();
		if (holding != null && holding.getItem() instanceof ItemToolBag3000) {
			return new GuiToolbag(new ContainerToolbag(player, player.inventory, new HeldInventory(player.getHeldItem())));
		}
		return null;
	}
}
