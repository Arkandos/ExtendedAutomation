package com.arkandos.extendedautomation.handler;

import com.arkandos.braincore.utility.compatibility.HarvestCraftHandler;
import com.arkandos.braincore.utility.compatibility.MekanismHandler;
import com.arkandos.braincore.utility.compatibility.WitcheryHandler;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration configuration;
    public static final String CATEGORY_MODULES = "modules";
    public static final String CATEGORY_MEKANISM = "mekanism";
    public static final String CATEGORY_MARICULTURE = "mariculture";

    public static int harvestcraftBiofuelValue = 4;
    public static int witcheryBiofuelValue = 2;
    public static int hcFishOilValue = 300;

    public static boolean HarvestCraftActive = true;
    public static boolean MekanismActive = true;
    public static boolean MaricultureActive = true;
    public static boolean WitcheryActive = true;

    public static void init(File configFile)
    {
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        loadModuleConfig();

        loadMekanismConfig();

        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    public static void loadModuleConfig(){
        // Modules
        HarvestCraftActive = configuration.getBoolean("Harvestcraft", CATEGORY_MODULES, true, "");
        MekanismActive = configuration.getBoolean("Mekanism", CATEGORY_MODULES, true, "");
        MaricultureActive = configuration.getBoolean("Mariculture", CATEGORY_MODULES, true, "");
        WitcheryActive =  configuration.getBoolean("Witchery", CATEGORY_MODULES, true, "");
    }

    public static void loadMekanismConfig(){
        // Mekanism
        if (MekanismActive)
        {
            if (HarvestCraftHandler.isLoaded() && HarvestCraftActive)
            {
                harvestcraftBiofuelValue = configuration.getInt("Harvestcraft biofuel value", CATEGORY_MEKANISM, 4, 0, 8, "The amount of biofuel each harvestcraft crop produces.");
            }

            if (WitcheryHandler.isLoaded() && WitcheryActive)
            {
                witcheryBiofuelValue = configuration.getInt("Witchery biofuel value", CATEGORY_MEKANISM, 2, 0, 8, "The amount of biofuel each witcherycrop produces.");
            }
        }
    }

    public static void loadMaricultureConfig(){
        // Mariculture
        if (MaricultureActive){
            hcFishOilValue = configuration.getInt("Harvestcraft fishoil value", CATEGORY_MARICULTURE, 300, 0, 5000, "The amount of fishoil each harvestcraft fish gives");
        }
    }

}
