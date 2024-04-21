import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final int PORT = 2082;

    private static DatagramSocket datagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    public static void main(String[] args) {
        System.out.println("Opening port. . . \n");
        try{
            datagramSocket = new DatagramSocket(PORT);
        } catch (SocketException e) {
           System.out.println("UNABLE TO OPEN PORT" + new RuntimeException(e));
           System.exit(1);
        }
        handleClient();
    }

    public static void handleClient(){
        try{
            String messageIn, messageOut;
            int numMessages = 0;
            InetAddress clientAddress = null;
            int clientPort;
            do{
                buffer = new byte[256]; //step 2
                inPacket = new DatagramPacket(buffer, buffer.length); //step 3
                datagramSocket.receive(inPacket);  //step 4

                clientAddress = inPacket.getAddress(); //step 5
                clientPort = inPacket.getPort();

                messageIn = new String(inPacket.getData(), 0, inPacket.getLength()); // step 6
                System.out.println("Message Received");
                numMessages++;
                messageOut = "Message " + numMessages + " : " + messageIn;

                outPacket = new DatagramPacket(messageOut.getBytes(), messageOut.length(), clientAddress, clientPort); //step 7
                datagramSocket.send(outPacket); //step 8
            }while(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
             System.out.println("\n * CLOSING THE CONNECTION");
             datagramSocket.close();
        }
    }
}