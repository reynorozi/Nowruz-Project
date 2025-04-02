package org.example;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class Parseinfo {

        ArrayList<Account> accounts ;
        public ArrayList<Account> parsinfo(){

            accounts = new ArrayList<>();
            String Data = File.ReadData();
            JSONObject obj = new JSONObject(Data);
            JSONArray users = obj.getJSONArray("Accounts");

            for(int i = 0; i < users.length(); i++) {

                JSONObject userobj = users.getJSONObject(i);
                Account account ;
                String Role = userobj.optString("Role");
                if ("Artist".equals(Role)) {
                    account = new Artist();
                }
                else {
                    account = new User();
                }

                account.setUsername(userobj.optString("Username"));
                account.setPassword(userobj.optString("Password"));
                account.setName(userobj.optString("Name","geust"));
                account.setAge(userobj.optInt("Age",0));
                accounts.add(account);

            }
return accounts;
        }
}
