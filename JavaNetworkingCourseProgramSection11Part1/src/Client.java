import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException {
        //SocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 5000);
        try(SocketChannel socketChannel = SocketChannel.open()){
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 5000));
            ByteBuffer byteBuffer = ByteBuffer.allocate(64);
            int bytesRead = socketChannel.read(byteBuffer);
            while (bytesRead > 0){
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println((char) byteBuffer.get() + "\n");
                }
                bytesRead = socketChannel.read(byteBuffer);
            }
        }catch (IOException e){
            throw  new RuntimeException(e);
        }
    }
}
