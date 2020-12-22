package com.mateeus.mining.listeners;

import com.mateeus.mining.builder.ItemBuilder;
import com.mateeus.mining.controller.PluginController;
import com.mateeus.mining.manager.PlayerManager;
import com.mateeus.mining.server.MTSkyMiningEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class MiningEvent implements Listener {

    private static final MTSkyMiningEvent plugin = (MTSkyMiningEvent) Bukkit.getPluginManager().getPlugin("MTSkyMiningEvent");
    private static final FileConfiguration fileCoonfig = plugin.getConfig();
    private static final ConfigurationSection cs = fileCoonfig.getConfigurationSection("coin");
    private static final Double chance = cs.getDouble("chance");

    public static void onMining(BlockBreakEvent e){
        if(PluginController.isEnabled()){
            Player player = e.getPlayer();
            if(PlayerManager.verifyRegion(player)){
                Double number = new Random().nextDouble();
                if(number < chance){
                    ItemStack coin = ItemBuilder.getCoin();
                    player.getInventory().addItem(coin);
                    player.sendMessage(ChatColor.GRAY + "Voce recebeu uma" + ChatColor.GOLD + " moeda");
                }
            }
        }
    }

}
