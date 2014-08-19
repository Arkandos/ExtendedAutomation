package com.arkandos.extendedautomation;


import com.arkandos.braincore.proxy.IProxy;
import com.arkandos.extendedautomation.utility.Reference;
import com.arkandos.extendedautomation.utility.compatibility.ModHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, dependencies = Reference.DEPENDENCIES, version = Reference.Version)
public class ExtendedAutomation
{

    @Mod.Instance(Reference.MOD_ID)
    public static ExtendedAutomation instance;

    @SidedProxy(clientSide = com.arkandos.braincore.utility.Reference.CLIENT_PROXY_CLASS, serverSide = com.arkandos.braincore.utility.Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModHandler.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModHandler.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        ModHandler.postInit();
    }
}
