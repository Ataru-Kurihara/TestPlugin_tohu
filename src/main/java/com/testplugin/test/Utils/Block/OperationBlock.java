package com.testplugin.test.Utils.Block;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class OperationBlock {
    public static void DeleteBlocks(World world, Location startPoint) {
        for (int j=0; j<5; j++) {
            for (int i=0; i<=100; i++) {
                startPoint.add(1,0,0);
                world.getBlockAt(startPoint).setType(Material.AIR);
            }
            startPoint.add(-100,0,0);
            startPoint.add(0,0,1);
            }
        for (int j=0; j<5; j++) {
            for (int i=0; i<=100; i++) {
                startPoint.add(-1,0,0);
                world.getBlockAt(startPoint).setType(Material.AIR);
            }
            startPoint.add(100,0,0);
            startPoint.add(0,0,1);
        }
        for (int j=0; j<5; j++) {
            for (int i=0; i<=100; i++) {
                startPoint.add(0,0,-1);
                world.getBlockAt(startPoint).setType(Material.AIR);
            }
            startPoint.add(0,0,-100);
            startPoint.add(1,0,0);
        }
        for (int j=0; j<5; j++) {
            for (int i=0; i<=100; i++) {
                startPoint.add(0,0,-1);
                world.getBlockAt(startPoint).setType(Material.AIR);
            }
            startPoint.add(0,0,-100);
            startPoint.add(-1,0,0);
        }
        }
}
