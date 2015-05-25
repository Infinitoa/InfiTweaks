package infi.mods.infiutil.inventory;

import infi.mods.infiutil.items.ItemToolBag3000;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class HeldInventory implements IInventory {

	private ItemStack bag;
	private ItemStack[] contents;

	public HeldInventory(ItemStack itemstack) {
		this.bag = itemstack;
		this.contents = new ItemStack[21];
		if (!itemstack.hasTagCompound()) {
			itemstack.setTagCompound(new NBTTagCompound());
		}
	}

	public void readFromNBT(NBTTagCompound comp) {
		// TODO
	}

	public void writeToNBT(NBTTagCompound comp) {
		// TODO
	}

	@Override
	public int getSizeInventory() {
		return contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return contents[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack itemstack = getStackInSlot(slot);
		if (itemstack == null) {
			return itemstack;
		} else if (itemstack.stackSize <= amount) {
			setInventorySlotContents(slot, null);
		} else {
			itemstack = itemstack.splitStack(amount);
			markDirty();
		}
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemstack = getStackInSlot(slot);
		setInventorySlotContents(slot, null);
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		this.contents[slot] = itemstack;
		markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return !(itemstack.getItem() instanceof ItemToolBag3000);
	}

	@Override
	public String getInventoryName() {
		return "Toolbag";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void markDirty() {
		// TODO
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
}
