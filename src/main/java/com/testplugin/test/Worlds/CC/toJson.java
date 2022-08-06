package com.testplugin.test.Worlds.CC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class toJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static String[][][] material_str = new setQuestion().question_str();
    static List<String> questionList = new ArrayList<>();
    public void main() {
        QuestionDate qd = new QuestionDate();
        qd.setId(1);
        qd.setRating(200);
        qd.setBlocks(material_str);
        questionList.add(String.valueOf(qd.getId()));
        questionList.add(String.valueOf(qd.getRating()));
        questionList.add(Arrays.deepToString(qd.getBlocks()));
        File file = new File("com/testplugin/test/Worlds/CC/sample.json");
        try {
            FileWriter fileWriter = new FileWriter(file);
            gson.toJson(questionList, fileWriter);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("question: " + gson.toJson(questionList));
    }
}
