package com.mars.cookedcarrots;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTabs;

import static com.mars.cookedcarrots.Constants.MOD_ID;

public class CookedCarrots implements ModInitializer {
    @Override
    public void onInitialize() {
        CommonClass.init();
        CommonClass.ITEMS.forEach((string, itemSupplier) -> Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, string), itemSupplier.get()));
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FOOD_AND_DRINKS)
                .register((itemGroup) -> CommonClass.ITEMS.forEach((string, itemSupplier) -> itemGroup.accept(itemSupplier.get())));
    }
}
