package com.mateeus.mining.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MarketCommand {

    public static void openInventory(Player player){
        Inventory inv = Bukkit.createInventory(null,54, ChatColor.GOLD + "Mercado");
        fillInventory(inv);
        player.openInventory(inv);
    }

    private static void fillInventory(Inventory inv){
        for (int i = 0; i < 54; i++){
            inv.setItem(i, getGlass());
        }
    }

    private static ItemStack getGlass(){
        return new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)1);
    }

}
