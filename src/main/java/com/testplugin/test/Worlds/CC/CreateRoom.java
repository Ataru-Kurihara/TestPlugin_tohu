package com.testplugin.test.Worlds.CC;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;

public class CreateRoom {
    int WIDTH = 4;
    int HEIGHT = 4;
    int WALL_NUM = 2;
    int N = 4;

    //床
    public void CreateFloors(int PlayerNum, World world, Location startPoint, Material material) {
        for (int i = 1; i <= (this.WIDTH+2)*PlayerNum; i++) {
            for (int j = 1; j <= this.HEIGHT+2; j++) {
                startPoint.add(1,0,0);
                world.getBlockAt(startPoint).setType(material);
            }
            startPoint.add(-(this.WIDTH+2),0,0);
            startPoint.add(0,0,1);
            //System.out.println(startPoint);
        }
        startPoint.add(0,0,-6*PlayerNum);
        //System.out.println("-------------------");
    }




    //前後左右の壁
    public void CreateWallsRL(int PlayerNum, World world, Location startPoint, Material material) {
//        System.out.println(startPoint);
        for (int m = 1; m <= PlayerNum; m++) {
            for (int i = 1; i <= this.WALL_NUM; i++) {
                for (int j = 1; j <= this.HEIGHT; j++) {
                    startPoint.add(0,1,0);
                    for (int k = 1; k <= this.WIDTH+2; k++) {
                        startPoint.add(1,0,0);
                        world.getBlockAt(startPoint).setType(material);
                    }
                    startPoint.add(-(this.WIDTH+2),0,0);
//                    System.out.println(startPoint);
                }
//            System.out.println("--------------------");
                startPoint.add(0,-this.WIDTH,0);
                startPoint.add(0,0, this.WIDTH+1);
//            System.out.println(startPoint);
//            System.out.println("--------------------");
            }
            //初期地点まで戻る
            startPoint.add(0,0, -10);
            System.out.println("初期地点"+startPoint);
            System.out.println();
            //次の壁の地点に移動
            startPoint.add(0,0,6);
            System.out.println("次の壁"+startPoint);
            System.out.println();

        };
        //初期地点に戻る
        startPoint.add(0,0,-6*PlayerNum);
        System.out.println("初期地点"+startPoint);
        System.out.println();

    }
//    //前後の壁
//    public void CreateWallsAB(int PlayerNum, World world, Location startPoint, Material material) {
//        startPoint.add(1, 0, 0);
//        for (int l = 1; l <= PlayerNum; l++) {
//            for (int k = 1; k <= this.WALL_NUM; k++) {
//                for (int j = 1; j <= this.HEIGHT; j++) {
//                    startPoint.add(0, 1, 0);
//                    for (int i = 1; i <= this.WIDTH; i++) {
//                        startPoint.add(0, 0, 1);
//                        world.getBlockAt(startPoint).setType(material);
//                    }
//                    startPoint.add(0, 0, -this.WIDTH);
//                    System.out.println(startPoint);
//                }
//                System.out.println("--------------------");
//                startPoint.add(0, -this.WIDTH, 0);
//                startPoint.add(this.WIDTH + 1, 0, 0);
//                System.out.println(startPoint);
//                System.out.println("--------------------");
//            }
//            startPoint.add(0,0,6);
//            startPoint.add(-11,0,0);
//        }
//        startPoint.add(0,0,-6);
//    }
//前後の壁
public void CreateWallsAB(int PlayerNum, World world, Location startPoint, Material material) {
    System.out.println(startPoint);
    startPoint.add(1,0,0);
    for (int i=1; i <= PlayerNum; i++) {
        for (int j=1; j <= this.WALL_NUM; j++) {
            for (int l=1; l <= this.HEIGHT; l++) {
                startPoint.add(0,1,0);
                for (int m=1; m<= this.WIDTH; m++) {
                    startPoint.add(0,0,1);
                    world.getBlockAt(startPoint).setType(material);
                }
                startPoint.add(0,0, -(this.WIDTH));
                System.out.println(startPoint);
            }
            System.out.println("--------------------");
            startPoint.add(0,-this.HEIGHT,0);
            startPoint.add(this.WIDTH+1,0,0);
            System.out.println(startPoint);
            System.out.println("--------------------");
        }
        startPoint.add(-10,0,0);
        System.out.println("初期地点"+startPoint);
        startPoint.add(0,0,this.WIDTH+1);
        System.out.println("次の壁"+startPoint);
    }
    startPoint.add(0,0,-(this.WIDTH+1));
    System.out.println("初期地点"+startPoint);

}

    //天井
    public void CreateCeilings(int PlayerNum, World world, Location startPoint, Material material) {
        startPoint.add(0, this.WIDTH+1 ,0);
        for (int i = 1; i <= this.WIDTH+2; i++) {
            for (int j = 1; j <= this.HEIGHT+2; j++) {
                startPoint.add(1,0,0);
                world.getBlockAt(startPoint).setType(material);

//                System.out.println(startPoint);
            }
            startPoint.add(-(this.WIDTH+2),0,0);
            startPoint.add(0,0,1);
//            System.out.println("---------------");
//            System.out.println(startPoint);
//            System.out.println("---------------");
        }
        startPoint.add(0, 0,-6);
        startPoint.add(0, -(this.WIDTH+1) ,0);
//        System.out.println(startPoint);


    }
    public void Create(int PlayerNum, World world, Location[] startPoint, Material material) {
          CreateFloors(PlayerNum, world, startPoint[0], material);
//          CreateWallsRL(PlayerNum, world, startPoint[1], material);
          CreateWallsAB(PlayerNum, world, startPoint[2], material);
//          CreateCeilings(PlayerNum, world, startPoint[3], material);
    }
}
