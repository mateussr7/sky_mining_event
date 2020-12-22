package com.mateeus.mining.manager;

import com.mateeus.mining.builder.ItemBuilder;
import com.mateeus.mining.server.MTSkyMiningEvent;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class PlayerManager {

    private static final MTSkyMiningEvent plugin = (MTSkyMiningEvent) Bukkit.getPluginManager().getPlugin("MTSkyMiningEvent");

    public static boolean verifyRegion(Player player){
        RegionManager manager = null;
        try {
            manager = MTSkyMiningEvent.getWorldGuard().getRegionManager(player.getWorld());
            ApplicableRegionSet set = manager.getApplicableRegions(player.getLocation());
            if(set.size() != 0){
                String id = set.iterator().next().getId();
                if(id.equalsIgnoreCase("mina-event")){
                    return true;
                }
                return false;
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
        return false;
    }

}
