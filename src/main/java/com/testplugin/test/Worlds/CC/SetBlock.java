package com.testplugin.test.Worlds.CC;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class SetBlock {
    Material[][][] materials = new setQuestion().Question();
    public void Set(World world, Location location){
            location.add(0,0,1);
            location.add(1,0,0);
            location.add(0,1,0);
            for (int i = 0; i < materials.length; i++) {
                for (int j = 0; j < materials.length; j++) {
                    for (int l = 0; l < materials.length; l++) {
                        location.add(1, 0, 0);
                        world.getBlockAt(location).setType(materials[i][j][l]);
                    }
                    location.add(-materials.length, 0, 0);
                    location.add(0, 0, 1);
                }
                location.add(0, 0, -materials.length+1);
                location.add(0,1,0);
                location.add(0,0,-1);
            }
    }
}
