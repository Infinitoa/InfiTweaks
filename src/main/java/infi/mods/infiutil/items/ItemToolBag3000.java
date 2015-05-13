package infi.mods.infiutil.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import infi.mods.infiutil.init.InitItems;
import infi.mods.infiutil.ref.Names;

public class ItemToolBag3000 extends ItemInfiUtilities implements IInventory{
	public ItemToolBag3000() {
		super();
		this.setMaxStackSize(1);
		this.setUnlocalizedName(Names.UNLOCALIZED_NAME_TOOLBAG3000);
	}
	
	@Override
	public int getSizeInventory() {
		return 0;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int count) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack itemstack) {
		
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public void markDirty() {
		
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return false;
	}

	@Override
	public void openInventory() {
		
	}

	@Override
	public void closeInventory() {
		
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack itemstack) {
		return itemstack.getUnlocalizedName() == InitItems.toolBag3000.getUnlocalizedName() ? false : true;
	}
}
