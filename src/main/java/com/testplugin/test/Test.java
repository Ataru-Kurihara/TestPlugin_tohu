package com.testplugin.test;

import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("on");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
