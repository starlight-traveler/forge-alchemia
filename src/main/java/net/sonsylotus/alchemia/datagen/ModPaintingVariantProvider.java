package net.sonsylotus.alchemia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sonsylotus.alchemia.AlchemiaMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Provides data generation for custom painting variants in MCCourseMod.
 */
public class ModPaintingVariantProvider extends PaintingVariantTagsProvider {

    /**
     * Constructor for ModPaintingVariantProvider.
     *
     * @param output Output for the data pack.
     * @param future Asynchronous computation of holder lookup provider.
     * @param existingFileHelper Helper for existing files, can be null.
     */
    public ModPaintingVariantProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future,
                                      @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, AlchemiaMod.MOD_ID, existingFileHelper);
    }

    /**
     * Adds tags for custom painting variants.
     *
     * @param pProvider Provider for holder lookup.
     */
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
    }

    /**
     * Adds a painting variant to the PLACEABLE tag.
     *
     * @param paintingName The name of the painting.
     */
    private void addPainting(String paintingName) {
        this.tag(PaintingVariantTags.PLACEABLE).addOptional(new ResourceLocation(AlchemiaMod.MOD_ID, paintingName));
    }
}
