package code2040Challenges;

import java.io.*;
import java.text.*;
import org.joda.time.*;
import org.json.*;

/**
 *
 * @author JennDiaz
 */
public class DatingGame extends JSONConnect {
    
    // Converts String to correct objects;
    public static String convertObj(String str) throws JSONException {
        try {
            JSONObject jObj = new JSONObject(str);
            String ds = jObj.getString("datestamp");
            int time = jObj.getInt("interval");
            System.out.println("Seconds: " + time + "\tDatestamp: " + ds);

            String updated = convertStringToTS(ds, time);
            return updated;

        } catch (JSONException e) {
            System.out.println("JSON error.");
        }
        return null;
    }
    
    // Converts String to TimeStamp and adjusts time
    public static String convertStringToTS(String str, int s) {
        String z = "Z";
        DateTime datetime = DateTime.parse(str);
        DateTime total = datetime.plusSeconds(s);
        
        // Used substring of result and concatenated a 'Z' at the end
        String result = total.toString();
        result = result.substring(0, 19);
        result = result.concat(z);

        return result;
    }

    public static void main(String[] args) throws IOException, JSONException, ParseException {
        String url = "http://challenge.code2040.org/api/dating";
        String key = "{\"token\":\"" + getToken() + "\"}";

        String str = connect(url, key);

        String updated = convertObj(str);
        System.out.println("\nPost addition: " + updated);

        // Complete validation
        url = "http://challenge.code2040.org/api/dating/validate";
        String keys = "{\"token\":\"" + getToken() + "\",\"datestamp\":\"" + updated + "\"}";
        connect(url, keys);
    }

}
