import java.io.InputStream;
import java.net.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

public class Main {
    //the readable bytebuffer channel allows us to read from thhe site using its read method
    //the bytebuffer  instance reveives data from the channel adn is used as the argumetn of read method
    //the buffer reader holds sixty four bites at a time
    private static ByteBuffer buffer;

    public static void main(String[] args) {
        try{
            URI uri = new URI("https://surreylearn.surrey.ac.uk/");
            URLConnection myurlCnnection = uri.toURL().openConnection();
            InputStream inputStream = myurlCnnection.getInputStream();
            //return teh num of bytes read
            ReadableByteChannel readableByteChannel = Channels.newChannel(inputStream);
            ByteBuffer buffer = ByteBuffer.allocate(64);

            String line = null;
            while(readableByteChannel.read(buffer) > 0){
                //read from teh buffer adnd print the line out here
                System.out.println(new String(buffer.array()));
                //clear the buffer so that it can be used again
                buffer.clear();
            }
            readableByteChannel.close();

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}