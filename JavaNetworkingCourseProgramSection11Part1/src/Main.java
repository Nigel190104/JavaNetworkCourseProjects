import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Time server is Started");
        try{
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open(); //create new socket
            serverSocketChannel.socket().bind(new InetSocketAddress(5000)); // bign socket to port 5000
            while (true){
                System.out.println("Waiting for Request ! ");
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    String dateTimeMessage = "DATE : " + new Date(System.currentTimeMillis());
                    ByteBuffer buffer = ByteBuffer.allocate(64);
                    buffer.put(dateTimeMessage.getBytes());
                    buffer.flip();
                    while (buffer.hasRemaining()){
                        socketChannel.write(buffer);
                    }

                    System.out.println("Sent : " + dateTimeMessage);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}