package com.mateeus.mining.manager;

import com.mateeus.mining.server.MTSkyMiningEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MarketManager {

    private static final MTSkyMiningEvent plugin = (MTSkyMiningEvent) Bukkit.getPluginManager().getPlugin("MTSkyMiningEvent");
    private static final FileConfiguration fileConfig = plugin.getConfig();

    public static Map<Integer, ItemStack> getSections(){
        ConfigurationSection cs = fileConfig.getConfigurationSection("market");
        Map<Integer, ItemStack> itens = new HashMap<>();
        Set<String> sections =  cs.getKeys(false);
        for(String s : sections){
            ConfigurationSection ci = cs.getConfigurationSection(s);
            ItemStack item = new ItemStack(Material.getMaterial(ci.getString("material")));
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(ci.getString("name").replace("&", "§"));
            item.setItemMeta(meta);
            itens.put(Integer.parseInt(s), item);
        }
        return itens;
    }

}
