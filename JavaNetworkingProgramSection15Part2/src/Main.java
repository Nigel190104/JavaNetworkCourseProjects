import java.net.*;
import java.io.*;
import java.nio.Buffer;


public class Main {
    public static void main(String[] args) throws IOException {
        if(args.length < 1) return;

        URL url = new URL(args[0]);

        //HTTP 80 HTTPS

        String hostname = url.getHost();


        int port = 80;

        try(Socket socket = new Socket(hostname, port)){
            OutputStream  output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            writer.println("HOST : " + hostname) ;
            writer.println("HEAD : " + url.getPath() + "HTTP/1.1");
            writer.println("USER AGENT : Simple user agent");
            writer.println("Accept    : text/html");
            writer.println("Connection : Close ");

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line;
            while((line = reader.readLine())!= null){
                System.out.println(line);
            }
        }catch (UnknownHostException ex){
            System.out.println("Error : " + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Error : " + ex.getMessage());

        }
    }


}