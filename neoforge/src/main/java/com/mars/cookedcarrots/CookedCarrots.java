package com.mars.cookedcarrots;


import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.mars.cookedcarrots.Constants.MOD_ID;

@Mod(Constants.MOD_ID)
public class CookedCarrots {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);
    public CookedCarrots(IEventBus eventBus) {
        CommonClass.init();

        CommonClass.ITEMS.forEach(ITEMS::register);
        ITEMS.register(eventBus);
        eventBus.addListener(CookedCarrots::buildContents);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            CommonClass.ITEMS.forEach((string, itemSupplier) -> event.accept(itemSupplier.get()));
        }
    }
}
