package com.mateeus.mining.builder;

import com.mateeus.mining.server.MTSkyMiningEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class ItemBuilder {

    private static final MTSkyMiningEvent plugin = (MTSkyMiningEvent) Bukkit.getPluginManager().getPlugin("MTSkyMiningEvent");
    private static final FileConfiguration fileConfig = plugin.getConfig();

    public static ItemStack getCoin(){
        ConfigurationSection cs = fileConfig.getConfigurationSection("coin");
        ItemStack item = new ItemStack(Material.getMaterial(cs.getString("material")));
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(cs.getString("name").replace("&", ""));
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, false);
        item.setItemMeta(meta);
        return item;
    }

}
