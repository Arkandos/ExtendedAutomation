package com.arkandos.extendedautomation.utility.compatibility;

import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.braincore.utility.compatibility.MekanismHandler;
import com.arkandos.braincore.utility.compatibility.MineFactoryReloadedHandler;
import com.arkandos.braincore.utility.compatibility.WitcheryHandler;
import com.arkandos.extendedautomation.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class WitcheryModule
{
    public static final String NAME = WitcheryHandler.getName();
    public static final String loadedMessage = "Taming the occult plants!";

    public static void preInit()
    {
        if (WitcheryHandler.isLoaded() && ConfigurationHandler.WitcheryActive)
        {
            ModHandler.printLoadedMessage(NAME, loadedMessage);
        }
    }

    public static void init()
    {
        if (WitcheryHandler.isLoaded() && ConfigurationHandler.WitcheryActive)
        {

        }
    }

    public static void postInit()
    {
        if(WitcheryHandler.isLoaded() && ConfigurationHandler.WitcheryActive)
        {
            registerPlants();
        }
    }

    public static void registerPlants()
    {

        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("sapling", GameRegistry.findUniqueIdentifierFor(GameRegistry.findBlock(NAME, "witchsapling")).toString());
        MineFactoryReloadedHandler.registerPlantableSapling(tag);

        MineFactoryReloadedHandler.registerHarvestableLeaves(GameRegistry.findUniqueIdentifierFor(GameRegistry.findBlock(NAME, "witchleaves")).toString());
        MineFactoryReloadedHandler.registerHarvestableLog(GameRegistry.findUniqueIdentifierFor(GameRegistry.findBlock(NAME, "witchlog")).toString());

        for (WitcheryHandler.Plants plant : WitcheryHandler.Plants.values())
        {
            tag = new NBTTagCompound();
            tag.setString("seed", GameRegistry.findUniqueIdentifierFor(GameRegistry.findItem(NAME, plant.getSeed())).toString());
            tag.setString("crop", GameRegistry.findUniqueIdentifierFor(GameRegistry.findBlock(NAME, plant.getPlant())).toString());
            MineFactoryReloadedHandler.registerPlantableCrop(tag);

            ItemStack is;
            is = GameRegistry.findItemStack(NAME, plant.getPlant(), 1);
            is.setItemDamage(4);
            MineFactoryReloadedHandler.registerHarvestableCrop(is);

            if (ConfigurationHandler.MekanismActive)
            {
                MekanismHandler.registerBiofuelRecipe(GameRegistry.findItemStack(NAME, plant.getSeed(), 1), ConfigurationHandler.witcheryBiofuelValue);
            }
        }
    }
}
