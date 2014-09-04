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

    public static int harvestcraftBiofuelValue = 4;
    public static int witcheryBiofuelValue = 2;

    public static boolean HarvestCraftActive = true;
    public static boolean MekanismActive = true;
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
        // Modules
        HarvestCraftActive = configuration.getBoolean("Harvestcraft", CATEGORY_MODULES, true, "");
        MekanismActive = configuration.getBoolean("Mekanism", CATEGORY_MODULES, true, "");
        WitcheryActive =  configuration.getBoolean("Witchery", CATEGORY_MODULES, true, "");


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


        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

}
