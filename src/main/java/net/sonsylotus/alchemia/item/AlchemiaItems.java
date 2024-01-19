package net.sonsylotus.alchemia.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sonsylotus.alchemia.AlchemiaMod;

/**
 * This class is responsible for registering items for Alchemia.
 */
public class AlchemiaItems {

    // The ITEMS field is a DeferredRegister object. It is used to register all custom items for the mod.
    // DeferredRegister is a Forge class that simplifies mod item registration.
    // ForgeRegistries.ITEMS refers to the registry of all items in Minecraft.
    public static final DeferredRegister<Item> ALCHEMIA_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, AlchemiaMod.MOD_ID);

    public static void register(IEventBus eventBus) {

        ALCHEMIA_ITEMS.register(eventBus);

    }
}
