package com.mars.cookedcarrots;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

import static com.mars.cookedcarrots.Constants.MOD_ID;

public class CookedCarrots implements ModInitializer {
    @Override
    public void onInitialize() {
        CommonClass.init();
        CommonClass.ITEMS.forEach((string, itemSupplier) -> Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, string), itemSupplier.get()));
    }
}
