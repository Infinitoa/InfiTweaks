package infi.mods.infiutil.inventory;

import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotToolbag extends Slot {

	public SlotToolbag(HeldInventory bag, int id, int x, int y) {
		super(bag, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack) {
		return !(itemstack.getItem() instanceof ItemToolBag3000);
	}
}
