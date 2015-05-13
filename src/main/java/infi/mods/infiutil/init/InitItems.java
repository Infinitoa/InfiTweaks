package infi.mods.infiutil.init;

import infi.mods.infiutil.items.ItemInfiUtilities;
import infi.mods.infiutil.items.ItemToolBag3000;
import infi.mods.infiutil.ref.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitItems {
	public static final ItemInfiUtilities toolBag3000 = new ItemToolBag3000();

	public static void init() {
		GameRegistry.registerItem(toolBag3000, Names.UNLOCALIZED_NAME_TOOLBAG3000);
	}

}
