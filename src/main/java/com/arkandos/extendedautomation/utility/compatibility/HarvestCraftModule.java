package com.arkandos.extendedautomation.utility.compatibility;


import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.braincore.utility.compatibility.HarvestCraftHandler;
import com.arkandos.extendedautomation.utility.Reference;

public class HarvestCraftModule
{
    static HarvestCraftHandler hc = new HarvestCraftHandler();
    public static void preInit()
    {
        if (hc.isLoaded())
        {

        }
    }

    public static void init()
    {
        if (hc.isLoaded())
        {

        }
    }

    public static void postInit()
    {
        if(hc.isLoaded())
        {
            registerPlants();
        }
    }

    public static void registerPlants()
    {
        for (HarvestCraftHandler.Crops name : HarvestCraftHandler.Crops.values())
        {
            hc.registerCrop(name.getSeed(), name.getCrop());
        }
    }
}
