package net.sonsylotus.alchemia;

import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sonsylotus.alchemia.effect.AlchemiaEffects;
import net.sonsylotus.alchemia.item.AlchemiaItems;
import net.sonsylotus.alchemia.potion.custom.AlchemiaPotionsCustom;
import net.sonsylotus.alchemia.potion.vanilla.AlchemiaPotionsVanilla;
import net.sonsylotus.alchemia.util.CreativeUtil;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(AlchemiaMod.MOD_ID)
public class AlchemiaMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "alchemiamod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public AlchemiaMod() {

        /* --------------- Implementation of Mod --------------- */


        // Event Bus for Forge Mod Loader (FML) events.
        // This is where you register listeners for mod events, such as setup or config changes.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        AlchemiaItems.register(modEventBus);

        AlchemiaPotionsCustom.register(modEventBus);

        AlchemiaPotionsVanilla.register(modEventBus);

        AlchemiaEffects.register(modEventBus);

        CreativeUtil.register(modEventBus);

        /* -------------- Implementation of Setup -------------- */


        // Registering a setup method for mod loading
        // This is called during the initialization phase of the game and mod loading.
        modEventBus.addListener(this::commonSetup);

        // Register this class to listen to events from the global MinecraftForge event bus.
        // Useful for server events, player events, etc.
        MinecraftForge.EVENT_BUS.register(this);

        // Registering a method to modify the contents of the creative mode inventory tab.
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


    }

    private void commonSetup(final FMLCommonSetupEvent event) {



//        if (Config.logDirtBlock)
//            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
//        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);
//        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
