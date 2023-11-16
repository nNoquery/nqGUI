package me.qdm.nqgui;

import me.qdm.nqgui.nqCommands.nqAwards;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class NqGUI extends JavaPlugin {
    public static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();
        getCommand("awards").setExecutor(new nqAwards());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
