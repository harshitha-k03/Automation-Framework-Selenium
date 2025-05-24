package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;

public class CreateJsonData {
    public static void main(String[] args) {
        try {
            // Create JSON array
            JSONArray jsonArray = new JSONArray();

            // Add first data set
            JSONObject data1 = new JSONObject();
            data1.put("username", "user1");
            data1.put("password", "pass1");
            jsonArray.add(data1);

            // Add second data set
            JSONObject data2 = new JSONObject();
            data2.put("username", "user2");
            data2.put("password", "pass2");
            jsonArray.add(data2);

            // Write to file
            FileWriter file = new FileWriter("src/test/resources/testdata.json");
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();

            System.out.println("testdata.json created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}