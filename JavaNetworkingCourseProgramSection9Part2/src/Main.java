import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static ServerSocket serverSocket;

    private static final  int PORT = 1234;

    public static void main(String[] args) {
            System.out.println("OPENING PORT :  " + PORT + "\n");
            try {
                serverSocket = new ServerSocket(PORT);
            } catch (IOException e) {
                System.out.println("UNABLE TO ATTACH TO PORT ! ===" + new RuntimeException(e));
                throw new RuntimeException(e);
            }
            do{
                handleCLient();
            }while (true);

    }
    private  static void handleCLient(){
        Socket link = null;
        try{
            link = serverSocket.accept();

            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);

            int numMessages  = 0;
            String message = input.nextLine();
            while(!message.equals("***CLOSES***")){
                System.out.println("MESSAGE RECEIVED " + message);
                numMessages++;
                output.println("MESSAGE NUM " + numMessages + " : " + message );
                message = input.nextLine();
            }
            output.println(numMessages + " Message received");

        } catch (IOException e) {
            System.out.println(new RuntimeException(e));
            throw new RuntimeException(e);
        } finally {
            try{
                System.out.println("\n* CLOSING CONNECTION ... *");
                link.close();
            } catch (IOException e) {
                System.out.println("UNABLE TO DISCONNECT ! : " + new RuntimeException(e));
            }
        }

    }
}