package com.mars.cookedcarrots;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mars.cookedcarrots.Constants.MOD_ID;

@Mod(MOD_ID)
public class CookedCarrots {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public CookedCarrots() {
        CommonClass.init();
        var eventBus = FMLJavaModLoadingContext.get().getModBusGroup();

        CommonClass.ITEMS.forEach(ITEMS::register);
        ITEMS.register(eventBus);
        BuildCreativeModeTabContentsEvent.getBus(eventBus).addListener(CookedCarrots::buildContents);
    }

    @SubscribeEvent
    public static void buildContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            CommonClass.ITEMS.forEach((string, itemSupplier) -> event.accept(itemSupplier.get()));
        }
    }
}
