//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException {
//          InetAddress ocsaly = InetAddress.getByName("www.ocsaly.com");
//          System.out.println("HOST ADDRESS        : " + ocsaly.getHostAddress());
//          System.out.println("CANONCIAL HOST NAME : " + ocsaly.getCanonicalHostName());
//          System.out.println("HOST NAME           : " + ocsaly.getHostName());
//          ocsaly.isReachable(10000);


//        FileChannel;
//        //UDP
//        DatagramChannel;
//        //two channels below are TCP
//        SocketChannel;
//        ServerSocketChannel;


//this goes through each line of html in the specified webpage and prints it to the console
        try {
            URI uri = new URI("https://surreylearn.surrey.ac.uk/");
            URLConnection myurlCnnection = uri.toURL().openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(myurlCnnection.getInputStream()));
            String myLine;
            while ((myLine = br.readLine()) != null) {
                System.out.println(myLine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}