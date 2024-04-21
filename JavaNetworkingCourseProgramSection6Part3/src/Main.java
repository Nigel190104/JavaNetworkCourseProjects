import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        String web = "https://en.wikipedia.org/wiki/URL#Citations";

        URL myurl = new URL(web);

        getURL(myurl);
    }

    static void getURL(URL url){
        System.out.println("HOST = " + url.getHost());
        System.out.println("PATH = " + url.getPath());
        System.out.println("REF  = " + url.getRef());
        //port returns value of -1 showing that we have not connected to the website yet
        System.out.println("PORT = " + url.getPort());
    }
}