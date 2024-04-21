import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length < 1){
            return;
        }

        String domainName = args[0];
        String hostname = "whois.internic.net";
        int port = 43;

        try(Socket socket = new Socket(hostname, port)){
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(domainName);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            String line;

            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException ex){
            System.out.println("ERROR : " + ex.getMessage());
        }
    }
}