import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //1024-65535
        ServerSocket serverSocket = new ServerSocket(1092);

        //the server waits indefinitely for the client to connect
        //this is done by calling method except of server  circuit
        // which returns a circuti object when a conneciotn is made
        Socket link = serverSocket.accept();

        //setup input and output streams
        //which are used to get references to the socket weve created above called link
        //these are used for communication with the client that had just made the connection for
        //non-graphical users application a scanner object can be used to rap around the input stream
        //object returend by the method
        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream());

        //we need a way to send and recieve data
        //this will be done through the next line for receiving data and the method print line for sending data
        output.println("Awaiting for data ....");
        String myinput = input.nextLine();

        //closing the connection after the completion of the dialog
        link.close();
    }
}