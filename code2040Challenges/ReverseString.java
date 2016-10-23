package code2040Challenges;

import java.io.*;

/**
 *
 * @author JennDiaz
 */
public class ReverseString extends JSONConnect{

    public static String reverseString(String str) {
        StringBuffer buffer = new StringBuffer(str);
        String reversed = buffer.reverse().toString();
        System.out.println("Reversed string: " + buffer);
        System.out.println("");
        return reversed;
    }
   
    public static void main(String[] args) throws IOException {
        String url = "http://challenge.code2040.org/api/reverse";
        String key = "{\"token\":\"" + getToken() + "\"}";
        String response = connect(url, key);

        // Call reverseString method
        String result = reverseString(response);

        // Complete validation
        url = "http://challenge.code2040.org/api/reverse/validate";
        String keys = "{\"token\":\"" + getToken() + "\",\"string\":\"" + result + "\"}";
        connect(url, keys);
    }
}
