package com.testplugin.test.Worlds;

import com.testplugin.test.Test;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class Lobby implements Listener {
    private Test plugin;
    public String worldName = "lobby";
    public Location spawnPlace;
    public World world;
    public Lobby(Test plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld(this.worldName);
        this.spawnPlace = new Location(world, 252,4,-44);
    }

    //ワールド移動時
    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e) {
        if (e.getPlayer().getWorld() == this.world) {
            Player player = e.getPlayer();
            player.sendMessage("Hello");
            player.sendTitle("Lobby","",20,20,20);
            player.getInventory().clear();
            player.setFoodLevel(20);
            player.setHealth(20);
            player.setFlying(false);
            player.getWorld().setPVP(false);
            if (!player.isOp()) {
                player.sendMessage("権限がないよ");
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {//この部分でsleep(ディレイ)を入れてる
                    @Override
                    public void run() {
                        Bukkit.getLogger().info("Later");
                        player.setGameMode(GameMode.ADVENTURE);
                    }
                }, 5);
            }else{
                player.sendMessage("権限があるよ");
                Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {//この部分でsleep(ディレイ)を入れてる
                    @Override
                    public void run() {
                        Bukkit.getLogger().info("Later");
                        player.setGameMode(GameMode.CREATIVE);
                    }
                }, 5);
            }
        }
    }
    //爆発させない(ブロック置けないからそもそもいらないかも)
    @EventHandler
    public void onBlockExplode(BlockExplodeEvent e) {
        if (e.getBlock().getWorld() == this.world) {
            e.setCancelled(true);
        }
    }

    //ブロックを置かせない(権限持ちも同じにするか？)
    @EventHandler
    public void onSetBlock(BlockPlaceEvent e) {
        if (e.getPlayer().getWorld() == this.world) {
            e.setCancelled(true);
        }
    }

    //ブロックを壊せない
    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (e.getPlayer().getWorld() == this.world) {
            e.setCancelled(true);
        }
    }
}

