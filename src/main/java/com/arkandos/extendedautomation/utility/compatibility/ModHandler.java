package com.arkandos.extendedautomation.utility.compatibility;

import com.arkandos.braincore.utility.LogHelper;
import com.arkandos.extendedautomation.utility.Reference;

public class ModHandler
{
    public static void preInit()
    {
        HarvestCraftModule.preInit();
        MaricultureModule.preInit();
        WitcheryModule.preInit();
    }

    public static void init()
    {
        HarvestCraftModule.init();
        MaricultureModule.init();
        WitcheryModule.init();
    }

    public static void postInit()
    {
        HarvestCraftModule.postInit();
        MaricultureModule.postInit();
        WitcheryModule.postInit();
    }

    public static void printLoadedMessage(String modName, String message){
        LogHelper.info(Reference.MOD_ID, "Loaded " + modName + ". " + message);
    }
}
