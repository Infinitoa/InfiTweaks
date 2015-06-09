package infi.mods.infiutil.inventory;

import infi.mods.infiutil.items.ItemToolBag3000;
import infi.mods.infiutil.utilities.Utility;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class HeldInventory implements IInventory {

	private ItemStack bag;
	private ItemStack[] contents;
	private int UID;

	public HeldInventory(ItemStack itemstack) {
		this.bag = itemstack;
		this.contents = new ItemStack[21];
		this.UID = Utility.getNewID();
		if (!itemstack.hasTagCompound()) {
			itemstack.setTagCompound(new NBTTagCompound());
		}
		this.assignNewID();
		this.readFromNBT(itemstack.getTagCompound());
	}

	private void assignNewID() {
		/*
		 * TODO
		 * Causes problems, as it is called on both, Client and Server side
		 * Might result in ID mismatch?
		 * How to prevent?
		 */
		NBTTagCompound compound = bag.getTagCompound();
		if (!compound.hasKey("Identifier")) {
			System.out.println("Setting new ID");
			compound.setInteger("Identifier", this.UID);
			System.out.println(this.UID);
		}
	}

	public void readFromNBT(NBTTagCompound compound) {
		NBTTagList tags = compound.getTagList("Contents", 10);
		for (int i = 0; i < tags.tagCount(); i++) {
			NBTTagCompound itemComp = tags.getCompoundTagAt(i);
			int slot = itemComp.getInteger("Slot");
			if (slot >= 0 && slot < this.getSizeInventory()) {
				contents[slot] = ItemStack.loadItemStackFromNBT(itemComp);
			}
		}
	}

	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList tags = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); i++) {
			if (this.getStackInSlot(i) != null) {
				NBTTagCompound itemComp = new NBTTagCompound();
				itemComp.setInteger("Slot", i);
				this.getStackInSlot(i).writeToNBT(itemComp);
				tags.appendTag(itemComp);
			}
		}
		compound.setTag("Contents", tags);
	}

	@Override
	public int getSizeInventory() {
		return this.contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return this.contents[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack itemstack = getStackInSlot(slot);
		if (itemstack == null) {
			return null;
		} else if (itemstack.stackSize <= amount) {
			this.contents[slot] = null;
		} else {
			itemstack = itemstack.splitStack(amount);
		}
		markDirty();
		return itemstack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemstack = getStackInSlot(slot);
		this.setInventorySlotContents(slot, itemstack);
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
		/*
		 * TODO
		 * For some reason this is called 2 times for every slot each time the inventory opens(42 times total) 
		 * on Client side only
		 * Why? 
		 * Could this be due to onSlotChanged()?
		 */
		this.writeToNBT(bag.getTagCompound());
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
}
