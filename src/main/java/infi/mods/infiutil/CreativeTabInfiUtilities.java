package infi.mods.infiutil;

import infi.mods.infiutil.init.InitItems;
import infi.mods.infiutil.ref.References;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabInfiUtilities {

	public static final CreativeTabs INFIUTIL_TAB = new CreativeTabs(References.MOD_ID) {

		@Override
		public Item getTabIconItem() {
			return InitItems.toolBag3000;
		}
	};
}
