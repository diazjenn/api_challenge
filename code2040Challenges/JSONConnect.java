package code2040Challenges;

import java.io.*;
import java.net.*;

/**
 *
 * @author JennDiaz
 */
public class JSONConnect {

    // Private instance variables
    private static final String TOKEN = "24e5804d1332a3ae387923c1de783b61";

    public static String getToken() {
        return TOKEN;
    }

    // Requests and returns POST from server
    public static String connect(String u, String k) throws IOException {
        BufferedReader bReader;
        OutputStream oS;
        URL obj = new URL(u);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // Adding request headers
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        con.setRequestProperty("Content-Type", "application/json");

        String input = k;
        System.out.println("Sending POST request: " + "\n" + input);

        oS = con.getOutputStream();
        oS.write(input.getBytes());
        oS.flush();

        bReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

        // Reads and writes output from server
        String output;
        StringBuilder response = new StringBuilder();
        System.out.println("\nOutput from server...");

        while ((output = bReader.readLine()) != null) {
            response.append(output);
        }

        bReader.close();
        con.disconnect();

        //Prints result for user
        System.out.println(response.toString());
        return response.toString();
    }
}
