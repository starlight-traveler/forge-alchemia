package net.sonsylotus.alchemia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PoiTypeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.PoiTypeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sonsylotus.alchemia.AlchemiaMod;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModPoiTypeTagsProvider extends PoiTypeTagsProvider {
    public ModPoiTypeTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future,
                                  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, future, AlchemiaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        addPoi("sound_poi");
    }

    /**
     * Adds a painting variant to the PLACEABLE tag.
     *
     * @param poiName The name of the painting.
     */
    private void addPoi(String poiName) {
        this.tag(PoiTypeTags.ACQUIRABLE_JOB_SITE).addOptional(new ResourceLocation(AlchemiaMod.MOD_ID, poiName));
    }
}
