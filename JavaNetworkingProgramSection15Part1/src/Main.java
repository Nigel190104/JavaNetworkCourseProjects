import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        //past link that the image is from in the fileURl and it dowloads it to the JavaNetworkingProgramSection15Part1 folder in production
        String fileUrl = "https://hd.wallpaperswide.com/thumbs/rise_of_the_ronin_2024_video_game-t2.jpg";
        String saveDir = "C:\\Users\\Hp\\JavaNetworkingProgramSection15Part1\\out\\production\\JavaNetworkingProgramSection15Part1";
        try{
            HttpDownloader.downloadFile(fileUrl, saveDir);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}