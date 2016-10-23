package code2040Challenges;

import java.io.*;

public class Registration extends JSONConnect{

    // Private final instance varibles
    private static final String GITHUB = "https://github.com/diazjenn/api_challenge/";

    public static void main(String args[]) throws IOException {

        String url = "http://challenge.code2040.org/api/register";
        String keys = "{\"token\":\"" + getToken() + "\",\"github\":\"" + GITHUB + "\"}";

        // Send a POST request
        connect(url, keys);
    }
}
