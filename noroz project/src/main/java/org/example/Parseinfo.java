package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Parseinfo {

    static ArrayList<Account> accounts;

    /**
     * This method parses the user data from a JSON file and creates a list of Account objects.
     * It reads the JSON file data and retrieves the list of "Accounts".
     * For each account in the JSON, it checks if the role is "Artist", "User", or "Admin".
     * Based on the role, it creates the appropriate object and adds it to the list.
     *
     * @return an ArrayList of Account objects
     */
    public static ArrayList<Account> parsinfo() {

        accounts = new ArrayList<>();
        String Data = File.ReadData(); // Read the JSON data from the file
        JSONObject obj = new JSONObject(Data); // Convert the data to a JSONObject
        JSONArray users = obj.getJSONArray("Accounts"); // Get the "Accounts" array from the JSON

        for (int i = 0; i < users.length(); i++) {
            JSONObject userobj = users.getJSONObject(i); // Get each user object from the array
            String Role = userobj.optString("Role"); // Get the role (Artist/User/Admin) of the account

            Account account = null; // Initialize account

            // Check the role and create the appropriate object
            if ("Artist".equals(Role)) {
                account = new Artist(
                        userobj.optString("Username"),
                        userobj.optInt("Age", 0),
                        userobj.optString("Password"),
                        userobj.optString("Name", "guest")
                );
            } else if ("User".equals(Role)) {
                account = new User(
                        userobj.optString("Username"),
                        userobj.optInt("Age", 0),
                        userobj.optString("Password"),
                        userobj.optString("Name", "guest")
                );
            } else if ("Admin".equals(Role)) {
                account = new Admin(
                        userobj.optString("Username"),
                        userobj.optInt("Age", 0),
                        userobj.optString("Password"),
                        userobj.optString("Name", "guest")
                );
            }

            // Add the account only if it was created successfully
            if (account != null) {
                accounts.add(account);
            }
        }

        return accounts; // Return the list of accounts
    }
}
