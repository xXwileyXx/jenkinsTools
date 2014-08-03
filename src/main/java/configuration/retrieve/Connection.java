package configuration.retrieve;

import java.io.*;
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
        int i;
        try {
            url = new URL("http://localhost:8080/jenkins/api/xml");
            con = url.openConnection();

            File file = new File("Address.txt");
            BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
            System.out.println("File is --->" + url.getContent());
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file.getName()));
            	            while ((i = bis.read()) != -1) {
                                bos.write(i);
                            }
            	            bos.flush();
            	            bis.close();
            	        } catch (MalformedInputException malformedInputException) {
            	            malformedInputException.printStackTrace();
            	        } catch (IOException ioException) {
            	            ioException.printStackTrace();
            	        }
        	    }

}
