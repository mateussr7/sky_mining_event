package com.mateeus.mining.commands;

import com.mateeus.mining.controller.PluginController;
import com.mateeus.mining.server.MTSkyMiningEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class EventCommands {

    private static final MTSkyMiningEvent plugin = (MTSkyMiningEvent) Bukkit.getPluginManager().getPlugin("MTSkyMiningEvent");
    private static final FileConfiguration fileConfig = plugin.getConfig();

    public static void deployEvent(){
        if(!PluginController.isEnabled()){
            PluginController.enablePlugin();
            sendMessagesEventDeploy();
        }
    }

    public static void sendMessagesEventDeploy(){
        ConfigurationSection cs = fileConfig.getConfigurationSection("event");
        List<String> messages = cs.getStringList("begin-event");
        for (String string : messages) {
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', string));
        }
    }

    public static void sendMessagesFinishEvent(){
        ConfigurationSection cs = fileConfig.getConfigurationSection("event");
        List<String> messages = cs.getStringList("finish-event");
        for(String string : messages){
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', string));
        }
    }

    public static void cancellEvent(){
        if(PluginController.isEnabled()){
            PluginController.disablePlugin();
            sendMessagesFinishEvent();
        }
    }

}
