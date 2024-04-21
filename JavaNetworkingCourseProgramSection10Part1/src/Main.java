import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.channels.DatagramChannel;

public class Main {
    public static void main(String[] args) throws IOException {

        //step 1 Create a Diagram Socket Object
        DatagramSocket datagramSocket = new DatagramSocket(2082); //step 1
        //step 2 create a buffer
        byte[] buffer = new byte[256]; //step 2
        //step 3 Create a datagramPaket for the incoing datagrams
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length); // step 3
        //step 4 acccept and icnomign datagram
        datagramSocket.receive(datagramPacket); //step 4
        //step 5 accept the senders address adn port from the packet
        InetAddress clientAddress = datagramSocket.getInetAddress(); //step 5
        //step 6 retrieve the data from the buffer
        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
        //step 7 Create the response the datagram
        DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(), clientAddress, datagramPacket.getPort());
        //step 8 Send the response datagram
        datagramSocket.send(outPacket);
        //step 9 close the datagramSocket !!
        datagramSocket.close();

    }
}


//in this section we will develop a datagram application that uses udp packets
//to interact with server and client side
//unlike TCP IP sockets, datagram sokcets are connection less
//this means that the connection between the client and server is not maintained
//throughout the duration of the dialogue
//each datagram packet is sent as an isolated transmission whenever necessary
//however this way of doign connection is incredibly unreliable since the conennection is not
//maintained between transmissions unlike tcp ip