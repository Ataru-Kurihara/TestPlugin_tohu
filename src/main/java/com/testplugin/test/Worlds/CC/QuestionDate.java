package com.testplugin.test.Worlds.CC;

public class QuestionDate {
    private int id;
    private int rating;
    private String[][][] blocks;

    public void setId(int Id) {
        this.id = Id;
    }

    public void setRating(int Rating) {
        this.rating = Rating;
    }

    public void setBlocks(String[][][] Blocks) {
        this.blocks = Blocks;
    }

    public int getId() {
        return id;
    }
    public int getRating() {
        return rating;
    }
    public String[][][] getBlocks() {
        return blocks;
    }
}
