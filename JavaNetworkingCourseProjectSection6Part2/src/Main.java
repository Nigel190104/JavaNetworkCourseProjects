import java.net.*;
import java.util.Collections;
import java.util.Enumeration;


public class Main {
    public static void main(String[] args) throws URISyntaxException {
        //teh terms URN and URI are used ot refere to teh name and location of an internet resources
        //a uri identifies the name or a resource such as a web site or a file on the internet

        String uri = "https://techbinz.com/ecu-ecm-power-managment";
        URI webURI = new URI("https", "techbinz.com", "ecu-ecm-power-managment");
        getURI(webURI);

    }

    static void getURI(URI myURI){
        System.out.println(myURI.getAuthority());
        System.out.println(myURI.getPath());
        System.out.println(myURI.getHost());
        System.out.println(myURI.getPort());
        System.out.println(myURI.getScheme());
        System.out.println(myURI.getQuery());
    }
}