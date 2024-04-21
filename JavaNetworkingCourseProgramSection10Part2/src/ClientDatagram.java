import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ClientDatagram {

    private static final int PORT = 2082;

    private static DatagramSocket datagramSocket;
    private static DatagramPacket inPacket, outPacket;
    private static byte[] buffer;

    private static InetAddress host;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("Error : " + new RuntimeException(e));
            System.exit(1);
        }
        accessServer();
    }

    private static void accessServer(){
        try{
            datagramSocket = new DatagramSocket(); //1
            Scanner userEntry = new Scanner(System.in);
            String message = "", resposne = "";
            do{
                System.out.println("Enter Message : ");
                message = userEntry.nextLine();
                if(!message.equals("***CLOSE***")){
                    outPacket = new DatagramPacket(message.getBytes(), message.length(), host, PORT); //2
                    datagramSocket.send(outPacket);//3
                    buffer = new byte[256];//5
                    inPacket = new DatagramPacket(buffer, buffer.length);//5
                    datagramSocket.receive(inPacket);//6
                    resposne = new String(inPacket.getData(), 0, inPacket.getLength());//7
                    System.out.println("\n SERVER RESPONSE > " + resposne);
                }
            }while (!message.equals("***CLOSE***"));
        } catch (IOException e) {
            System.out.println("ERROR " + new RuntimeException(e).getMessage());
            throw new RuntimeException(e);

        }finally {
            System.out.println("\n *Closing connection ... *");
            datagramSocket.close();
        }
    }

}
