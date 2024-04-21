import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSide {

    private  static InetAddress host;

    private static final int PORT = 1234 ;

     public static void main(String[] args) {
                try {
                    host = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    System.out.println("ERROR CAUSED : " + new RuntimeException(e).getMessage());
                    System.exit(1);
                }
                accessServer();
     }

     private static void accessServer(){
         Socket link = new Socket();

         try{
             link = new Socket(host, PORT);
             Scanner input = new Scanner(link.getInputStream());

             PrintWriter output = new PrintWriter(link.getOutputStream(), true);
             Scanner userEntry = new Scanner(System.in);
             String message,  response;
             do{
                 System.out.println("ENTER MESSAGE : ");
                 message =  userEntry.nextLine();
                 output.println(message);
                 response = input.nextLine();
                 System.out.println("\n SERVER > " + response);
             }while (!message.equals("***CLOSE***"));

         } catch (IOException e) {
             throw new RuntimeException(e);
         }finally {
             try{
                 System.out.println("\n*CLOSING CONNECTION...*");
                 link.close();
             } catch (IOException e) {
                 System.out.println("Unable to Disconnect Error" + new RuntimeException(e).getMessage());
                 System.exit(1);
             }
         }
     }
}
