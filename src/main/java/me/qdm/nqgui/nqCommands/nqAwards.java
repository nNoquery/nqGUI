package me.qdm.nqgui.nqCommands;

import org.bukkit.entity.Item;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.ChatColor;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import me.qdm.nqgui.NqGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

import org.bukkit.inventory.Inventory;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class nqAwards implements CommandExecutor, Listener {
    public Player player;
    public Inventory awards;
    public List<Integer> arr = List.of(20, 22, 24);

    public ItemMeta faward, king, sf;



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        player = (Player) sender;
        Plugin plugin = NqGUI.getPlugin();
        YamlConfiguration config = (YamlConfiguration) plugin.getConfig();
        if (args.length > 0) {
            sender.sendMessage(c(config.getString("messages.noexecute")));
            return true;
        }
        awards = Bukkit.createInventory((InventoryHolder) null, 54, c("&6&l\u041d\u0430\u0433\u0440\u0430\u0434\u044b"));
        ItemStack faward = new ItemStack(Material.AMETHYST_SHARD, 1);
        ItemMeta itemMeta = faward.getItemMeta();
        itemMeta.setDisplayName(c(config.getString("messages.awarddefault")));
        String configString = c(config.getString("messages.awardlore1"));
        List<String> s = new ArrayList<String>();
        for (int i = 0; i < configString.split("\n").length; ++i) {
            s.add(configString.split("\n")[i]);
        }
        itemMeta.setLore((List) s);
        faward.setItemMeta(itemMeta);
        awards.setItem(20, faward);

        ItemStack king = new ItemStack(Material.RAW_GOLD, 1);
        ItemMeta itemMeta1 = king.getItemMeta();
        itemMeta1.setDisplayName(c(config.getString("messages.kingname")));
        String configString1 = c(config.getString("messages.kinglore"));
        List<String> s1 = new ArrayList<String>();
        for (int i = 0; i < configString1.split("\n").length; ++i) {
            s1.add(configString1.split("\n")[i]);
        }
        itemMeta1.setLore(s1);
        king.setItemMeta(itemMeta1);
        awards.setItem(22, king);

        ItemStack sf = new ItemStack(Material.GOLD_INGOT, 1);
        ItemMeta im2 = sf.getItemMeta();
        im2.setDisplayName(c(config.getString("messages.sfname")));
        String cfglore = c(config.getString("messages.sflore"));
        List<String> s2 = new ArrayList<String>();
        for (int i = 0; i < cfglore.split("\n").length; i++) {
            s2.add(cfglore.split("\n")[i]);
        }
        im2.setLore(s2);
        sf.setItemMeta(im2);
        awards.setItem(24, sf);


        player.openInventory(awards);


        plugin.getServer().getPluginManager().registerEvents((Listener) this, plugin);
        return true;
    }

    public String c(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    @EventHandler
    public void onRightClickfaward(InventoryClickEvent e) {
       // if (awards.equals(king))
       // {
        if (e.getWhoClicked() != player) {
            return;
        }
        if (arr.stream().filter(a -> a.equals(e.getSlot())).count() == 0) {
            e.setCancelled(true);
            return;
        }
       // }

        //player.sendMessage(e.getSlot()+"");
        //if (arr.stream().filter(s -> s.equals(e.getSlot())).count() == 0) {
        //e.setCancelled(true);
        // return;
        // }


        switch (e.getSlot()) {
            case 20: {
                player.sendMessage(c("&e\u041d\u0430\u0433\u0440\u0430\u0434\u0430 \u0443\u0441\u043f\u0435\u0448\u043d\u043e \u043f\u043e\u043b\u0443\u0447\u0435\u043d\u0430!"));
                break;
            }
            case 22: {
                player.sendMessage(c("123"));
                break;
            }
            case 24: {
                player.sendMessage(c("678"));
                break;
            }
        }
        player.closeInventory();
    }

    @EventHandler
    public void invClose(InventoryCloseEvent e) {
        if (e.getPlayer() != player) {
            return;
        }
        InventoryClickEvent.getHandlerList().unregister((Listener) this);
        InventoryCloseEvent.getHandlerList().unregister((Listener) this);
    }



}

