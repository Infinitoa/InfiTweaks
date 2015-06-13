package infi.mods.infiutil.inventory;

import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerToolbag extends Container {

	public HeldInventory inventoryBag;
	private static final int BAG_INV_START = 0;
	private static final int BAG_INV_END = 20;
	private static final int INV_PLAYER_START = 21;
	private static final int INV_PLAYER_END = 57;

	public ContainerToolbag(EntityPlayer player, InventoryPlayer playerInventory, HeldInventory inventoryBag) {
		this.inventoryBag = inventoryBag;

		// Toolbag Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 7; j++) {
				addSlotToContainer(new SlotToolbag(this.inventoryBag, j + i * 7, 26 + 18 * j, 18 + 18 * i));
			}
		}

		// Player Hotbar
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(playerInventory, i, 8 + 18 * i, 144));
		}

		// Player Inventory
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + 18 * j, 86 + 18 * i));
			}
		}
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int pos) {
		Slot slot = getSlot(pos);
		if (slot != null && slot.getHasStack()) {
			if (!(slot.getStack().getItem() instanceof ItemToolBag3000)) {
				ItemStack itemstack = slot.getStack();
				ItemStack returnStack = itemstack.copy();
				if (pos <= this.BAG_INV_END) {
					// Try to move it to player inventory
					if (!mergeItemStack(itemstack, this.INV_PLAYER_START, this.INV_PLAYER_END, false)) {
						return null;
					}
				} else {
					// Try to move it to bag inventory
					if (!mergeItemStack(itemstack, this.BAG_INV_START, this.BAG_INV_END, false)) {
						return null;
					}
				}
				if (itemstack.stackSize != 0) {
					slot.onSlotChanged();
				} else {
					slot.putStack(null);
				}
				slot.onPickupFromSlot(player, itemstack);
				return returnStack;
			}
		}
		return null;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}

	@Override
	public ItemStack slotClick(int slot, int buttonMouse, int mode, EntityPlayer player) {
		if (slot >= 0 && getSlot(slot).getStack() == player.inventory.getCurrentItem() && getSlot(slot) != null) {
			return null;
		}
		return super.slotClick(slot, buttonMouse, mode, player);
	}

}
