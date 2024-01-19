package net.sonsylotus.alchemia.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.sonsylotus.alchemia.AlchemiaMod;

public class CreativeUtil {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AlchemiaMod.MOD_ID);

//    // Ordered Added, The Order Displayed
//    public static final RegistryObject<CreativeModeTab> COURSE_TAB = CREATIVE_MOD_TABS.register("course_tab",
//            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.GLASS_BOTTLE)
//                    .title(Component.translatable("creativetab.course_tab"))
//                    .displayItems((itemDisplayParameters, output) -> {
//                        List<RegistryObject<?>> itemsAndBlocks = Arrays.asList(
//                                // Items
//
//                                // Blocks
//
//                        );
//
//                        itemsAndBlocks.forEach(registryObject -> {
//                            Object itemOrBlock = registryObject.get();
//                            ItemStack itemStack;
//
//                            if (itemOrBlock instanceof Item) {
//                                itemStack = new ItemStack((Item) itemOrBlock);
//                            } else if (itemOrBlock instanceof Block) {
//                                itemStack = new ItemStack((Block) itemOrBlock);
//                            } else {
//                                throw new IllegalStateException("Unknown object in creative tab: " + itemOrBlock);
//                            }
//
//                            output.accept(itemStack);
//                        });
//
//                    })
//                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
