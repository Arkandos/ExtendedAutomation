package com.arkandos.extendedautomation.utility.compatibility;

public class ModHandler
{
    public static void preInit()
    {
        HarvestCraftModule.preInit();
        WitcheryModule.preInit();
    }

    public static void init()
    {
        HarvestCraftModule.init();
        WitcheryModule.init();
    }

    public static void postInit()
    {
        HarvestCraftModule.postInit();
        WitcheryModule.postInit();
    }
}
