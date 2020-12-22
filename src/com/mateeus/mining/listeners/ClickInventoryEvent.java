package com.mateeus.mining.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickInventoryEvent implements Listener {

    public static void onClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Mercado")){
            e.setCancelled(true);
        }
    }
}
