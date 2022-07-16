package com.testplugin.test.Worlds.CC;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class toJson {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    static String[][][] material_str = new setQuestion().question_str();
    static Question question = new Question(1, 200, material_str);
    static List<Question> questionList = new ArrayList<>();
    public void main() {
        questionList.add(question);
        File file = new File("./sample.json");
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
