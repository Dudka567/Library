import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException{
        InputStreamReader user = new InputStreamReader(System.in);
        Library library = new Library("src/main/resources/map.txt",user);


    }
}
