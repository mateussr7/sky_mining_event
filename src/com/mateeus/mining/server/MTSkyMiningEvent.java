package com.mateeus.mining.server;

import com.mateeus.mining.controller.PluginController;
import com.mateeus.mining.listeners.ClickInventoryEvent;
import com.mateeus.mining.listeners.MiningEvent;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MTSkyMiningEvent extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new MiningEvent(), this);
        Bukkit.getPluginManager().registerEvents(new ClickInventoryEvent(), this);
        getCommand("mercado").setExecutor(new Commands());
        PluginController.enablePlugin();
    }

    @Override
    public void onDisable() {

    }


    //Hook World Guard
    public static WorldGuardPlugin getWorldGuard() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldGuard");
        if(!(plugin instanceof WorldGuardPlugin)) {
            return null;
        }
        return (WorldGuardPlugin)plugin;
    }

    //Hook World Edit
    public static WorldEditPlugin getWordlEdit() {
        Plugin plugin = Bukkit.getPluginManager().getPlugin("WorldEdit");
        if(plugin instanceof WorldEditPlugin)
            return (WorldEditPlugin)plugin;
        return null;
    }
}
