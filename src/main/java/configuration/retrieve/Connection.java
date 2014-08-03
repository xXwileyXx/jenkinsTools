package configuration.retrieve;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.MalformedInputException;

/**
 * Created by wiley on 04/08/14.
 */
public class Connection {

    public static void main(String[] args) {
        URL url = null;
        URLConnection con = null;


        try {
            url = new URL("http://localhost:8080/jenkins/api/xml");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            con = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());

            System.out.println("File is --->" + url.getContent());
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}