package net.sonsylotus.alchemia.util;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.stream.IntStream;

public class InventoryUtil {

    // Static method to check if a player's inventory contains a specific item using streams
    public static boolean hasPlayerStackInInventory(Player player, Item item) {
        // Create a stream of integers representing slot indices from 0 to inventory size
        return IntStream.range(0, player.getInventory().getContainerSize())
                // Convert each integer to the ItemStack in that inventory slot
                .mapToObj(player.getInventory()::getItem)
                // Check if any ItemStack in the stream matches the condition:
                // It should not be empty and should be the specified item
                .anyMatch(stack -> !stack.isEmpty() && stack.is(item));
        // Returns true if any element in the stream matches the condition, else false
    }

    // Static method to find the first inventory slot index that contains a specific item using streams
    public static int getFirstInventoryIndex(Player player, Item item) {
        // Create a stream of integers representing slot indices from 0 to inventory size
        return IntStream.range(0, player.getInventory().getContainerSize())
                // Filter the stream to include only indices where the ItemStack
                // in that slot is not empty and matches the specified item
                .filter(i -> {
                    ItemStack stack = player.getInventory().getItem(i);
                    return !stack.isEmpty() && stack.is(item);
                })
                // Find the first element in the stream that matches the filter
                .findFirst()
                // If an element is found, return its value, otherwise return -1
                .orElse(-1);
    }
}
