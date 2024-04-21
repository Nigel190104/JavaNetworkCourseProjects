import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        //Network interface class provides the ability to get low level deveice addresses and many
        //systems are connected to multiple networks at the same time
        //this may be in the form of nic, wirltess e.g. lan or bluetooth
        //NI clas represents an ip address and provides information about this ip address
        //NIC is the point of connectin between a computer and a network

        try{
            Enumeration <NetworkInterface> networkIEnumeration  = NetworkInterface.getNetworkInterfaces();
            System.out.println("Network Display : \n");
            for(NetworkInterface element : Collections.list(networkIEnumeration)){
                System.out.printf("%-8s %-32s \n", element.getName(), element.getDisplayName());
            }
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }
}