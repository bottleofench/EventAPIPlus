package api.bottleofench.eventapi;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class EventAPIPlus extends JavaPlugin {

    private static JavaPlugin instance;

    public static JavaPlugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;

        Bukkit.getPluginManager().registerEvents(new EventCaller(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
