package infi.mods.infiutil.items;

import infi.mods.infiutil.InfiUtilities;
import infi.mods.infiutil.ref.Names;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolBag3000 extends ItemInfiUtilities {

	public ItemToolBag3000() {
		this.setMaxStackSize(1);
		this.setUnlocalizedName(Names.UNLOCALIZED_NAME_TOOLBAG3000);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			// player.openGui(InfiUtilities.instance, 0, player.worldObj, (int)
			// player.posX, (int) player.posY, (int) player.posZ);
			FMLNetworkHandler.openGui(player, InfiUtilities.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
		}
		return itemstack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack itemstack) {
		return 1;
	}

	@Override
	public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
		super.onCreated(itemstack, world, player);
		itemstack.stackTagCompound = new NBTTagCompound();
		itemstack.stackTagCompound.setInteger("Identifier", super.getNewID());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean bool) {
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
			if (itemstack.stackTagCompound != null) {
				info.add("ID: " + itemstack.stackTagCompound.getInteger("Identifier"));
			}
		}
	}
}
