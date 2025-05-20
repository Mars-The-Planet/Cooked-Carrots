package com.mars.cookedcarrots;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mars.cookedcarrots.platform.Services;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashMap;

public class CommonClass {
    public static final HashMap<String, Supplier<Item>> ITEMS = new HashMap<>();
    public static final Supplier<Item> COOKED_CARROT = Suppliers.memoize(() -> new Item(new Item.Properties().food(
            new FoodProperties.Builder().fast().alwaysEdible().nutrition(3).saturationModifier(0.6F).build())));

    public static void init() {
        ITEMS.put("cooked_carrot", COOKED_CARROT);

        DeimosRecipeGenerator.createSmeltingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 200, 0.35f);
        DeimosRecipeGenerator.createSmokingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 100, 0.35f);
        DeimosRecipeGenerator.createCampfireCookingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 600, 0);
    }
}
