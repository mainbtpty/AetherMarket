package com.aethermarket;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public final class AetherMarket extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getLogger().info("§aAetherMarket has been enabled!");
        if (getCommand("market") != null) {
            getCommand("market").setExecutor(this);
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("§cAetherMarket has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }

        if (command.getName().equalsIgnoreCase("market")) {
            // Demo custom item
            ItemStack customItem = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = customItem.getItemMeta();
            
            if (meta != null) {
                meta.setDisplayName("§6§lAether Blade");
                List<String> lore = new ArrayList<>();
                lore.add("§7A premium market exclusive item");
                lore.add("§7CustomModelData: 10001");
                meta.setLore(lore);
                meta.setCustomModelData(10001);
                customItem.setItemMeta(meta);
            }

            player.getInventory().addItem(customItem);
            player.sendMessage("§a§lWelcome to AetherMarket!");
            player.sendMessage("§7Premium auction system ready.");
            return true;
        }

        return false;
    }
}
