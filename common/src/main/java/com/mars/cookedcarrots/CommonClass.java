package com.mars.cookedcarrots;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mars.deimos.datagen.DeimosRecipeGenerator;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.Consumables;

import java.util.HashMap;

import static com.mars.cookedcarrots.Constants.MOD_ID;

public class CommonClass {
    public static final HashMap<String, Supplier<Item>> ITEMS = new HashMap<>();
    public static final Supplier<Item> COOKED_CARROT = Suppliers.memoize(() -> new Item(new Item.Properties().useItemDescriptionPrefix().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MOD_ID, "cooked_carrot")))
            .food(new FoodProperties.Builder().alwaysEdible().nutrition(3).saturationModifier(0.6F).build(), Consumables.DRIED_KELP)));

    public static void init() {
        ITEMS.put("cooked_carrot", COOKED_CARROT);

        DeimosRecipeGenerator.createSmeltingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 200, 0.35f);
        DeimosRecipeGenerator.createSmokingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 100, 0.35f);
        DeimosRecipeGenerator.createCampfireCookingJson("minecraft:carrot", "cookedcarrots:cooked_carrot", 600, 0);
    }
}
