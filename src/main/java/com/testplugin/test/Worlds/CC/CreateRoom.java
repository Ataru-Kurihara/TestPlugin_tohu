package com.testplugin.test.Worlds.CC;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class CreateRoom {
    int WIDTH = 4;
    int HEIGHT = 4;
    int WALL_NUM = 2;
    int N = 4;

    public void CreateFloors(int PlayerNum, World world, Location startPoint, Material material) {
        for (int i = 1; i <= this.WIDTH+2 * PlayerNum; i++) {
            for (int j = 1; j <= this.HEIGHT+2; j++) {
                startPoint.add(1,0,0);
                world.getBlockAt(startPoint).setType(material);
            }
            startPoint.add(-(this.WIDTH+2)*PlayerNum,0,0);
            startPoint.add(0,0,1);
        }
    }
    public void CreateWallsRL(int PlayerNum, World world, Location startPoint, Material material) {
        for (int i = 1; i <= this.WALL_NUM * PlayerNum; i++) {
            for (int j = 1; j <= this.HEIGHT; j++) {
                startPoint.add(0,1,0);
                for (int k = 1; k <= this.WIDTH+2; k++) {
                    startPoint.add(1,0,0);
                    world.getBlockAt(startPoint).setType(material);
                }
                startPoint.add(-(this.WIDTH+2),0,0);
            }
            startPoint.add(0,-this.WIDTH,0);
            startPoint.add(0,0, this.WIDTH+1);
        }
    }
    public void CreateWallsAB(int PlayerNum, World world, Location startPoint, Material material) {
        startPoint.add(1,0,0);
        for (int k=1; k<=this.WALL_NUM; k++) {
            for (int j=1; j<=this.HEIGHT; j++) {
                startPoint.add(0,1,0);
                for (int i=1; i<= this.WIDTH; i++) {
                    startPoint.add(0,0,1);
                    world.getBlockAt(startPoint).setType(material);
                }
                startPoint.add(0,0,-this.WIDTH);
            }
            startPoint.add(0,-this.WIDTH,0);
            startPoint.add(this.WIDTH+1,0,0);
        }
    }
    public void CreateCeilings(int PlayerNum, World world, Location startPoint, Material material) {
        startPoint.add(0, this.WIDTH+1 ,0);
        for (int i = 1; i <= this.WIDTH+2 * PlayerNum; i++) {
            for (int j = 1; j <= this.HEIGHT+2; j++) {
                startPoint.add(1,0,0);
                world.getBlockAt(startPoint).setType(material);
            }
            startPoint.add(-(this.WIDTH+2)*PlayerNum,0,0);
            startPoint.add(0,0,1);
        }
    }
    public void Create(int PlayerNum, World world, Location[] startPoint, Material material) {
        CreateFloors(PlayerNum, world, startPoint[0], material);
        CreateWallsRL(PlayerNum, world, startPoint[1], material);
        CreateWallsAB(PlayerNum, world, startPoint[2], material);
        CreateCeilings(PlayerNum, world, startPoint[3], material);
    }
}
