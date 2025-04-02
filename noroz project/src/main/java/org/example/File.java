package org.example;

import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class File {


    public static String ReadData(){

        String Data = null;
        try {
            Data = new String(Files.readAllBytes(Paths.get("Data.json")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Data;
    }
    public static void WriteData(JSONObject obj) {

        try (FileWriter file = new FileWriter("Data.json")) {
            file.write(obj.toString(4));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
