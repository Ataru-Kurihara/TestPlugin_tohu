package com.testplugin.test.Utils.Player;

import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.List;

public class GetPlayers {
    public static int getPlayersNum(World world) {
        int num = world.getPlayers().size();
        return num;
    }
    public static List<Player> getPlayersName(World world) {
        List<Player> players = world.getPlayers();
        return players;
    }
}
