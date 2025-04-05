package org.example;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {


    public static String ReadData() {
        String data = null;
        try {
            Path filePath = Paths.get("Data.json");
                if (!Files.exists(filePath)) {

                JSONObject initialData = new JSONObject();
                JSONObject accounts = new JSONObject();
                initialData.put("Accounts", accounts);
                WriteData(initialData);
            }
            data = new String(Files.readAllBytes(filePath));

        } catch (IOException e) {

            throw new RuntimeException("Error reading data from file", e);

        }
        return data;
    }
    public static void WriteData(JSONObject obj) {
        try {

            String jsonData = ReadData();
            JSONObject oldData = new JSONObject(jsonData);


            oldData.put("Accounts", obj.getJSONArray("Accounts"));


            try (FileWriter file = new FileWriter("Data.json")) {
                file.write(oldData.toString(4));
                file.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
