package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class File {

    // Method to read data from the "Data.json" file
    public static String ReadData() {
        String data = null;
        try {
            Path filePath = Paths.get("Data.json");

            // If the file does not exist, create it with initial data
            if (!Files.exists(filePath)) {
                JSONObject initialData = new JSONObject();
                JSONArray accounts = new JSONArray();  // Use JSONArray instead of JSONObject for accounts
                initialData.put("Accounts", accounts);

                // Directly write the initial data into the file
                try (FileWriter file = new FileWriter("Data.json")) {
                    file.write(initialData.toString(4));
                    file.flush();
                }
            }

            // Read the file content and convert it to a string
            data = new String(Files.readAllBytes(filePath));

        } catch (IOException e) {
            // If an error occurs while reading the file, throw an exception
            throw new RuntimeException("Error reading data from file", e);
        }
        return data;
    }

    // Method to write data to the "Data.json" file
    public static void WriteData(JSONObject newData) {
        try {
            // Read the existing data from the file
            String jsonData = ReadData(); // Get the current data from the file
            JSONObject oldData = new JSONObject(jsonData); // Convert it to a JSONObject

            // Replace the old "Accounts" data with the new one
            oldData.put("Accounts", newData.getJSONArray("Accounts")); // Update the Accounts data

            // Write the updated data back to the file
            try (FileWriter file = new FileWriter("Data.json")) {
                file.write(oldData.toString(4)); // Pretty print the JSON
                file.flush(); // Ensure the data is written to the file
            }
        } catch (IOException e) {
            // If an error occurs while writing to the file, print the stack trace
            e.printStackTrace();
        }
    }
}
