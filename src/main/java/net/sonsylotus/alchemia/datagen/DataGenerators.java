package net.sonsylotus.alchemia.datagen;

// Importing necessary Minecraft and Forge classes for data generation.

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sonsylotus.alchemia.AlchemiaMod;

import java.util.concurrent.CompletableFuture;

/**
 * This class is responsible for setting up data generators that are used to create game assets like recipes, loot tables, etc.
 * It listens to Forge's GatherDataEvent and initializes various data providers.
 */
@Mod.EventBusSubscriber(modid = AlchemiaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    /**
     * The gatherData method is called when Forge fires the GatherDataEvent.
     * This method sets up different data generators for both server and client side.
     *
     * @param event The GatherDataEvent provided by Forge during data generation phase.
     */
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        // The DataGenerator object is central to data generation. It orchestrates the process and handles the output.
        DataGenerator generator = event.getGenerator();

        // The PackOutput represents the output location for generated data (like the 'generated' resources folder).
        PackOutput packOutput = generator.getPackOutput();

        // The ExistingFileHelper is a utility to assist with data generation by referencing existing files.
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // CompletableFuture for HolderLookup.Provider for looking up various game objects during data generation.
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        // Adding providers for server-side data like recipes and loot tables.
        // Each provider is responsible for generating a specific type of data.
       // generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));

        // Creating and adding a BlockTagsProvider, which is responsible for generating block tags.
        BlockTagsProvider blockTagsProvider = new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper);
        generator.addProvider(event.includeServer(), blockTagsProvider);

        // Creating and adding an ItemTagsProvider, which is responsible for generating item tags.
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));

        // Adding providers for client-side data like item models and block states.
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, AlchemiaMod.MOD_ID, existingFileHelper));

        // Adding a provider for global loot modifiers.
        generator.addProvider(event.includeClient(), new ModGlobalLootModifierProvider(packOutput, AlchemiaMod.MOD_ID));

        // Adding providers for painting variants.
        generator.addProvider(event.includeClient(), new ModPaintingVariantProvider(packOutput, lookupProvider, existingFileHelper));

        // Adding providers for villager POI variants.
        generator.addProvider(event.includeClient(), new ModPoiTypeTagsProvider(packOutput, lookupProvider, existingFileHelper));

        // Adding providers for advancement variants.
        //generator.addProvider(event.includeClient(), new ForgeAdvancementProvider(packOutput, lookupProvider, existingFileHelper,
         //       List.of(new ModAdvancementProvider())));

        // Adding providers for fluid variants.
        generator.addProvider(event.includeClient(), new ModFluidTagsProvider(packOutput, lookupProvider, existingFileHelper));

    }
}
