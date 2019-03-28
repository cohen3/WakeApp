import java.io.IOException;
import java.sql.Time;
import java.util.*;
import java.util.PriorityQueue;

public class main {
    private int startNumber = 1234;
    // CoffeeOrder<String,String, Time> = <ID,Description,toWhen>
    PriorityQueue<CoffeeOrder> queue= new PriorityQueue<>(20);
    public static void main(String[] args) throws IOException {
        StartingServer();
    }
    private static void StartingServer() {
        Server server = new Server();
        server.start();
        StartCLI();
        server.stop();
    }

    private static void StartCLI() {
        System.out.println("Server started!");
        System.out.println("Enter 'exit' to close server.");
        Scanner reader = new Scanner(System.in);
        do {
            System.out.print(">>");
        } while (!reader.next().toLowerCase().equals("exit"));
    }

    private String generateName(){
        String place_num = Integer.toHexString(startNumber);
        startNumber++;
        return place_num;
    }
    public void checkRush(){
    }



}

