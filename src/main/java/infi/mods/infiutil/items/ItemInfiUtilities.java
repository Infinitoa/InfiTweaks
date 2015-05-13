package infi.mods.infiutil.items;

import infi.mods.infiutil.creativetabs.CreativeTabInfiUtilities;
import infi.mods.infiutil.ref.References;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfiUtilities extends Item {
	public ItemInfiUtilities() {
		super();
		this.setCreativeTab(CreativeTabInfiUtilities.INFIUTIL_TAB);
	}

	private String getFormattedUnlocalizedName(String unlocalizedName) {
		return unlocalizedName.substring(5);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconregister) {
		itemIcon = iconregister.registerIcon(References.MOD_ID + ":" + getFormattedUnlocalizedName(super.getUnlocalizedName()));
	}
}
