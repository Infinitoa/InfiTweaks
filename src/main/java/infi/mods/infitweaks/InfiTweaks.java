package infi.mods.infitweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import infi.mods.infitweaks.proxies.IProxies;
import infi.mods.infitweaks.reference.References;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION)
public class InfiTweaks
{
	@Instance(References.MOD_ID)
	public static InfiTweaks instance;

	@SidedProxy(clientSide = References.CLASS_PROXY_CLIENT, serverSide = References.CLASS_PROXY_SERVER)
	public static IProxies proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		// Initialize Blocks and Items here, also read Configuration here
		// And register them with GameRegistry
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		// Initialize Recipes here
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		// Do things that depend on other mods being loaded already
	}
}
