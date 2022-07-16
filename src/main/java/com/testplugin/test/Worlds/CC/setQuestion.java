package com.testplugin.test.Worlds.CC;

import org.bukkit.Material;

import java.util.Arrays;

public class setQuestion {
    public Material[][][] material;
    public String[][][] material_str;

    public Material[][][] Question() {
            this.material = new Material[][][]{
                    //一段目
                    {
                            {Material.GOLD_BLOCK, Material.AIR, Material.AIR, Material.GOLD_BLOCK},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.GOLD_BLOCK, Material.AIR, Material.AIR, Material.GOLD_BLOCK}
                    },
                    //二段目
                    {
                            {Material.IRON_BLOCK, Material.AIR, Material.AIR, Material.IRON_BLOCK},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.IRON_BLOCK, Material.AIR, Material.AIR, Material.IRON_BLOCK}
                    },
                    //三段目
                    {
                            {Material.DIAMOND_BLOCK, Material.AIR, Material.AIR, Material.DIAMOND_BLOCK},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.DIAMOND_BLOCK, Material.AIR, Material.AIR, Material.DIAMOND_BLOCK}

                    },
                    //四段目
                    {
                            {Material.STONE, Material.AIR, Material.AIR, Material.STONE},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.AIR, Material.AIR, Material.AIR, Material.AIR},
                            {Material.STONE, Material.AIR, Material.AIR, Material.STONE}
                    }
            };
        return material;
    }
    public String[][][] question_str() {
        Material[][][] material = Question();
        String[][][] material_str = new String[material.length][material.length][material.length];
        for (int i=0; i< material.length; i++) {
            for (int j=0; j < material.length; j++) {
                for (int l=0; l < material.length; l++ ) {
                    material_str[i][j][l] = String.valueOf(material[i][j][l]);
                }
            }
        }
        return material_str;
    }
}
