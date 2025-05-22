package com.mars.cookedcarrots;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.mars.cookedcarrots.Constants.MOD_ID;

@Mod(Constants.MOD_ID)
public class CookedCarrots {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public CookedCarrots() {
        CommonClass.init();
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CommonClass.ITEMS.forEach(ITEMS::register);
        ITEMS.register(eventBus);
    }
}
