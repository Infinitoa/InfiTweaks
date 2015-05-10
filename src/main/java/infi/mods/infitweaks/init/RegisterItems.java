package infi.mods.infitweaks.init;

import infi.mods.infitweaks.items.ItemInfiTweaks;
import infi.mods.infitweaks.items.ItemPipTools3000;
import infi.mods.infitweaks.reference.References;
import cpw.mods.fml.common.registry.GameRegistry;

public class RegisterItems
{
	public static final ItemInfiTweaks pipTools3000 = new ItemPipTools3000();

	public static void initItems()
	{
		GameRegistry.registerItem(pipTools3000, "pipTools3000");
	}

}
