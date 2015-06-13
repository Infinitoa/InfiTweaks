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
	private int UID = 0;
	private boolean isRemote;

	public HeldInventory(ItemStack itemstack, boolean isRemote) {
		this.bag = itemstack;
		this.contents = new ItemStack[21];
		this.isRemote = isRemote;
		if (!this.bag.hasTagCompound()) {
			this.bag.setTagCompound(new NBTTagCompound());
		}
		// this.assignNewID();
		this.readFromNBT(this.bag.getTagCompound());
	}

	private void assignNewID() {
		NBTTagCompound compound = this.bag.getTagCompound();
		if (!compound.hasKey("Identifier") && !isRemote) {
			this.UID = Utility.getNewID();
			compound.setInteger("Identifier", this.UID);
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
			if (this.getStackInSlot(i) != null && this.getStackInSlot(i).stackSize > 0) {
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
		this.setInventorySlotContents(slot, null);
		return itemstack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		if (itemstack != null && itemstack.stackSize > getInventoryStackLimit()) {
			itemstack.stackSize = getInventoryStackLimit();
		}
		this.contents[slot] = itemstack;
		markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return !(itemstack.getItem() instanceof ItemToolBag3000);
	}

	@Override
	public String getInventoryName() {
		return "Toolbag 3000";
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
		if (isRemote) {
			return;
		}
		this.writeToNBT(this.bag.getTagCompound());
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}
}
