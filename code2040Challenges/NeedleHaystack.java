package code2040Challenges;

import java.io.*;
import org.json.*;

/**
 *
 * @author JennDiaz
 */
public class NeedleHaystack extends JSONConnect{
    
    // Locates matching string from array
    public static int getHaystackIdx(String str) {
        int idx = 0;
        
        try {
            JSONObject jObj = new JSONObject(str);
            JSONArray haystack = jObj.getJSONArray("haystack");
            String needle = jObj.getString("needle");

            for (int i = 0; i < haystack.length(); i++) {
                if (haystack.get(i).equals(needle)) {
                    idx = i;
                }
            }
        } catch (JSONException e) {
            System.out.println("JSON error.");
        } 
        return idx;   
    }
    
    public static void main(String[] args) throws IOException {
        String url = "http://challenge.code2040.org/api/haystack";
        String key = "{\"token\":\"" + getToken() + "\"}";
        
        String needle = connect(url, key);
        
        int haystackIdx = getHaystackIdx(needle);
        
        // Complete validation
        url = "http://challenge.code2040.org/api/haystack/validate";
        String keys = "{\"token\":\"" + getToken() + "\",\"needle\":\"" + haystackIdx + "\"}";
        connect(url, keys);

    }
}
