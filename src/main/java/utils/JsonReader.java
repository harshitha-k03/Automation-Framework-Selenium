package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonReader {
    public static List<String[]> readJson(String filePath) throws Exception {
        List<String[]> data = new ArrayList<>();
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(filePath);
        JSONArray jsonArray = (JSONArray) parser.parse(reader);
        for (Object obj : jsonArray) {
            JSONObject jsonObject = (JSONObject) obj;
            String[] rowData = new String[2];
            rowData[0] = (String) jsonObject.get("username");
            rowData[1] = (String) jsonObject.get("password");
            data.add(rowData);
        }
        reader.close();
        return data;
    }
}