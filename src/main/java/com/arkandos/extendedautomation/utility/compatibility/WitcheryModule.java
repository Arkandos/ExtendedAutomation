package com.arkandos.extendedautomation.utility.compatibility;

import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.braincore.utility.compatibility.MineFactoryReloadedHandler;
import com.arkandos.braincore.utility.compatibility.WitcheryHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class WitcheryModule
{
    public static final String NAME = WitcheryHandler.getName();

    public static void preInit()
    {
        if (WitcheryHandler.isLoaded())
        {

        }
    }

    public static void init()
    {
        if (WitcheryHandler.isLoaded())
        {

        }
    }

    public static void postInit()
    {
        if(WitcheryHandler.isLoaded())
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
            LogHelper.info("ExtendedAutomation", plant.getSeed());
            LogHelper.info("ExtendedAutomation", GameRegistry.findItem(NAME, plant.getSeed()).getUnlocalizedName());
            tag = new NBTTagCompound();
            tag.setString("seed", GameRegistry.findUniqueIdentifierFor(GameRegistry.findItem(NAME, plant.getSeed())).toString());
            tag.setString("crop", GameRegistry.findUniqueIdentifierFor(GameRegistry.findBlock(NAME, plant.getPlant())).toString());
            MineFactoryReloadedHandler.registerPlantableCrop(tag);

            ItemStack is;
            is = GameRegistry.findItemStack(NAME, plant.getPlant(), 1);
            is.setItemDamage(4);
            MineFactoryReloadedHandler.registerHarvestableCrop(is);
        }
    }
}
