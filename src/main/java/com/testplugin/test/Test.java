package com.testplugin.test;

import com.testplugin.test.Worlds.CC.CC;
import com.testplugin.test.Worlds.Lobby;
import org.bukkit.plugin.java.JavaPlugin;

public final class Test extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("on");
        new Lobby(this);
        new CC(this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
