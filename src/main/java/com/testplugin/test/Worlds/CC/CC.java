package com.testplugin.test.Worlds.CC;

import com.testplugin.test.Test;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import com.testplugin.test.Utils.Block.OperationBlock;
import com.testplugin.test.Utils.Player.GetPlayers;

import java.io.IOException;

public class CC implements Listener {
    Test plugin;
    public String worldName = "cc";
    public Location spawnPlace;
    public Location startPoint,startPoint_Walls_RL,startPoint_Walls_AB,startPoint_celling;
    public Location[] locations;
    World world;
    public int BUILD_START_X=1000;
    public int BUILD_START_Y=4;
    public int BUILD_START_Z=1000;


    public CC(Test plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.world = Bukkit.getWorld(this.worldName);
        this.spawnPlace = new Location(world,980,4,1020);
        this.startPoint = new Location(world, BUILD_START_X, BUILD_START_Y, BUILD_START_Z);
        this.startPoint_Walls_RL = new Location(world, BUILD_START_X, BUILD_START_Y, BUILD_START_Z);
        this.startPoint_Walls_AB = new Location(world, BUILD_START_X, BUILD_START_Y, BUILD_START_Z);
        this.startPoint_celling = new Location(world, BUILD_START_X, BUILD_START_Y, BUILD_START_Z);
        this.locations = new Location[3];
    }

    @EventHandler
    public void test(PlayerInteractEvent e) throws IOException {
        if (this.world != e.getPlayer().getWorld()) return;
        if (e.getItem() == null) return;
        int PlayerNum = 3;
        Player player = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            player.sendMessage(e.getItem().toString());
            ItemStack itemStack = e.getItem();
            this.locations = new Location[]{this.startPoint, this.startPoint_Walls_RL, this.startPoint_Walls_AB, this.startPoint_celling};
            if (itemStack.getType() == Material.GRASS) {
                player.sendMessage("clear");
                this.locations = new Location[]{this.startPoint, this.startPoint_Walls_RL, this.startPoint_Walls_AB, this.startPoint_celling};
                CreateRoom createRoom = new CreateRoom();
                createRoom.Create(PlayerNum, this.world, this.locations, Material.AIR);
            }
            else if (itemStack.getType() == Material.STONE) {
                player.sendMessage("create!!");
                this.locations = new Location[]{this.startPoint, this.startPoint_Walls_RL, this.startPoint_Walls_AB, this.startPoint_celling};
                CreateRoom createRoom = new CreateRoom();
                createRoom.Create(PlayerNum, this.world, this.locations, Material.GLASS);
            }
            else if (itemStack.getType() == Material.GLASS) {
                player.sendMessage("stone");
                this.startPoint = new Location(world, BUILD_START_X, BUILD_START_Y, BUILD_START_Z);
                SetBlock setBlock = new SetBlock();
                setBlock.Set(this.world, this.startPoint);
            }
            else if (itemStack.getType() == Material.GOLD_BLOCK) {
                player.sendMessage("change json");
                toJson Json = new toJson();
                Json.main();
            }
            else if (itemStack.getType() == Material.IRON_BLOCK) {
                player.sendMessage("change java");
                fromJson java = new fromJson();
                try {
                    java.FROM_JSON();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent e) {
        if (e.getPlayer().getWorld() == this.world) {
            Player player = e.getPlayer();
            player.sendTitle(this.worldName,"test",20,20,20);
            player.teleport(this.spawnPlace);
            player.getInventory().clear();
            int PlayerNum = GetPlayers.getPlayersNum(this.world);
            player.sendMessage(String.valueOf(PlayerNum));
            ItemStack[] items = {new ItemStack(Material.GRASS), new ItemStack(Material.STONE), new ItemStack(Material.GLASS), new ItemStack(Material.GOLD_BLOCK), new ItemStack(Material.IRON_BLOCK)};
            player.getInventory().addItem(items);

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
}
