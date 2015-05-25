package infi.mods.infiutil.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitRecipes {

	public static void init() {

		//@formatter:off	
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(InitItems.toolBag3000),
				"SwS",
				"wCw",
				"SwS", 
				'S', new ItemStack(Items.string),
				'w', new ItemStack(Blocks.wool, 1, 11), // Blue Wool
				'C', new ItemStack(Blocks.chest)));
	}
}
