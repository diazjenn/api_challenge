package code2040Challenges;

import java.io.*;
import java.util.*;
import org.json.*;
import com.google.gson.*;

public class Prefix extends JSONConnect {
    
    // Converts String to correct objects; locates correct strings in array
    public static ArrayList<String> findStrings(String str) {
        ArrayList<String> complete = new ArrayList<>();

        try {

            JSONObject jObj = new JSONObject(str);
            JSONArray arr = jObj.getJSONArray("array");
            String prefix = jObj.getString("prefix");
            String[] noPrefix = new String[arr.length()];

            for (int i = 0; i < arr.length(); i++) {
                if (!arr.getString(i).startsWith(prefix)) {
                    complete.add(arr.getString(i));
                }
            }
            return complete;

        } catch (JSONException e) {
            System.out.println("JSON Exception error.");
        }
        return null;
    }

    public static void main(String[] args) throws IOException {

        String url = "http://challenge.code2040.org/api/prefix";
        String key = "{\"token\":\"" + getToken() + "\"}";

        String str = connect(url, key);
        ArrayList<String> returned = findStrings(str);
        String jArr = new Gson().toJson(returned);

        // Complete validation
        url = "http://challenge.code2040.org/api/prefix/validate";
        String keys = "{\"token\":\"" + getToken() + "\",\"array\":" + jArr + "}";
        connect(url, keys);
    }

}
