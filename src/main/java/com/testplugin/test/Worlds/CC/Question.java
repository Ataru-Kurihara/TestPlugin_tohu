package com.testplugin.test.Worlds.CC;

import java.util.Arrays;
import java.util.List;

public class Question {
    public int id;
    public int rating;
    public String[][][] blocks;

    public Question(int id, int rating, String[][][] blocks) {
        this.id = id;
        this.rating = rating;
        this.blocks = blocks;
    }
}
