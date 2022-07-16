package com.testplugin.test.Worlds.CC;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

public class fromJson {
    public void FROM_JSON() throws Exception {
        String json = " {\n" +
                "    \"id\": 1,\n" +
                "    \"rating\": 200,\n" +
                "    \"blocks\": [\n" +
                "      [\n" +
                "        [\n" +
                "          \"GOLD_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"GOLD_BLOCK\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"GOLD_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"GOLD_BLOCK\"\n" +
                "        ]\n" +
                "      ],\n" +
                "      [\n" +
                "        [\n" +
                "          \"IRON_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"IRON_BLOCK\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"IRON_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"IRON_BLOCK\"\n" +
                "        ]\n" +
                "      ],\n" +
                "      [\n" +
                "        [\n" +
                "          \"DIAMOND_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"DIAMOND_BLOCK\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"DIAMOND_BLOCK\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"DIAMOND_BLOCK\"\n" +
                "        ]\n" +
                "      ],\n" +
                "      [\n" +
                "        [\n" +
                "          \"STONE\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"STONE\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\"\n" +
                "        ],\n" +
                "        [\n" +
                "          \"STONE\",\n" +
                "          \"AIR\",\n" +
                "          \"AIR\",\n" +
                "          \"STONE\"\n" +
                "        ]\n" +
                "      ]\n" +
                "    ]\n" +
                " }\n";
        URL resources = fromJson.class.getResource("/sample.json");
        System.out.println(resources);
        Gson gson = new Gson();
        InputStreamReader isr = new InputStreamReader(new FileInputStream("./sample.json"));
        JsonReader jsr = new JsonReader(isr);
        //Question question = gson.fromJson(json, Question.class);
        Question question = gson.fromJson(isr, Question.class);
        System.out.println("blocks: "+ Arrays.deepToString(question.blocks));

    }
}
