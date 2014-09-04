package com.arkandos.extendedautomation.utility.compatibility;


import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.braincore.utility.compatibility.HarvestCraftHandler;
import com.arkandos.braincore.utility.compatibility.MekanismHandler;
import com.arkandos.extendedautomation.handler.ConfigurationHandler;
import com.arkandos.extendedautomation.utility.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

public class HarvestCraftModule
{
    static HarvestCraftHandler hc = new HarvestCraftHandler();
    public static void preInit()
    {
        if (hc.isLoaded() && ConfigurationHandler.HarvestCraftActive)
        {

        }
    }

    public static void init()
    {
        if (hc.isLoaded() && ConfigurationHandler.HarvestCraftActive)
        {

        }
    }

    public static void postInit()
    {
        if(hc.isLoaded() && ConfigurationHandler.HarvestCraftActive)
        {
            registerPlants();
        }
    }

    public static void registerPlants()
    {
        for (HarvestCraftHandler.Crops name : HarvestCraftHandler.Crops.values())
        {
            hc.registerCrop(name.getSeed(), name.getCrop());
            if (ConfigurationHandler.MekanismActive)
            {
                MekanismHandler.registerBiofuelRecipe(GameRegistry.findItemStack(HarvestCraftHandler.getName(), name.getSeed(), 1), ConfigurationHandler.harvestcraftBiofuelValue);
            }
        }

        if (MekanismHandler.isLoaded() && ConfigurationHandler.MekanismActive)
        {
            for (HarvestCraftHandler.Fruits name : HarvestCraftHandler.Fruits.values() )
            {
                MekanismHandler.registerBiofuelRecipe(GameRegistry.findItemStack(HarvestCraftHandler.getName(), name.getFruit(), 1), ConfigurationHandler.harvestcraftBiofuelValue);
            }
        }
    }
}
