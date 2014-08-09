package main;

import static collector.ReadXMLCollector.getXmlElementInfo;

/**
 * Created by wiley on 09/08/14.
 */
public class Main {

    public static void main(String[] args) {
        String urlJenkins = "http://localhost:8080/jenkins/api/xml";

        String[] urls = (String[]) getXmlElementInfo(urlJenkins, "job", "url").toArray(new String[0]);

        System.out.println(getXmlElementInfo(urlJenkins, "job", "url"));

        for (String url : urls) {
            System.out.println(url + "-->" + getXmlElementInfo(url + "config.xml", "runPostStepsIfResult", "name"));
        }

    }
}
