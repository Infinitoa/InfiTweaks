package infi.mods.infitweaks;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;
import infi.mods.infitweaks.init.RegisterItems;
import infi.mods.infitweaks.items.ItemInfiTweaks;
import infi.mods.infitweaks.items.ItemPipTools3000;
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
		RegisterItems.initItems();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
