package infi.mods.infitweaks.items;

import infi.mods.infitweaks.reference.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfiTweaks extends Item
{
	public ItemInfiTweaks()
	{
		super();
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	private String getFormattedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(5);
	}

	/*
	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", References.MOD_ID + ":" + getFormattedUnlocalizedName(super.getUnlocalizedName()), ".name");
	}
	*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister)
	{
		itemIcon = iconregister.registerIcon(References.MOD_ID + ":"
				+ getFormattedUnlocalizedName(super.getUnlocalizedName()));
	}
}
