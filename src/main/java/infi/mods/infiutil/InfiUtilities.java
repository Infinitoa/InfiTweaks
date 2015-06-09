package infi.mods.infiutil;

import infi.mods.infiutil.init.InitItems;
import infi.mods.infiutil.init.InitRecipes;
import infi.mods.infiutil.proxies.CommonProxy;
import infi.mods.infiutil.ref.References;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class InfiUtilities {

	@Instance(References.MOD_ID)
	public static InfiUtilities instance;

	@SidedProxy(clientSide = References.CLASS_PROXY_CLIENT, serverSide = References.CLASS_PROXY_SERVER)
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		InitItems.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		InitRecipes.init();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, this.proxy);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
