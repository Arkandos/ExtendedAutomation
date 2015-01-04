package com.arkandos.extendedautomation.utility.compatibility;

import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.braincore.utility.compatibility.HarvestCraftHandler;
import com.arkandos.braincore.utility.compatibility.MaricultureHandler;
import com.arkandos.extendedautomation.handler.ConfigurationHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;

public class MaricultureModule {

    public static String NAME = MaricultureHandler.getName();
    public static final String loadedMessage = "Equipping snorkel.";
    public static boolean isModLoaded;

    public static void preInit(){
        if (MaricultureHandler.isLoaded() && ConfigurationHandler.MaricultureActive){
            isModLoaded = true;
            ModHandler.printLoadedMessage(NAME, loadedMessage);
        }
    }

    public static void init(){
        if (isModLoaded && ConfigurationHandler.MaricultureActive){

        }
    }

    public static void postInit(){
        if (isModLoaded && ConfigurationHandler.MaricultureActive){
            if (HarvestCraftHandler.isLoaded() && ConfigurationHandler.HarvestCraftActive){
                registerFishOil();
            }
        }
    }

    public static void registerFishOil(){
        FluidStack fishOil;

        fishOil = new FluidStack(FluidRegistry.lookupFluidForBlock(GameRegistry.findBlock(MaricultureHandler.getName(), "fish_oil")), ConfigurationHandler.hcFishOilValue);

        for (HarvestCraftHandler.Fish name : HarvestCraftHandler.Fish.values()){
            MaricultureHandler.addCrucibleRecipe(GameRegistry.findItemStack(HarvestCraftHandler.getName(), name.getFish(), 1), 180, fishOil, null, 0);
        }
    }
}
