import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int port = 6666;
    private volatile boolean stop;
    private static ExecutorService threadpool;

    public Server() {
        this.threadpool = Executors.newFixedThreadPool(10);
    }
    public void start() {new Thread(this::runServer).start();}
    private void runServer() {
        try {
            ServerSocket server = new ServerSocket(port);
            server.setSoTimeout(10);
            while (!stop) {
                try {
                    Socket clientSocket = server.accept(); // blocking call
                    this.threadpool.execute(new Thread(() ->
                            handleClient(clientSocket)));
                } catch (Exception e) { }
            }
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void handleClient(Socket clientSocket) {
        try {
            System.out.println("connected to Dude");
            System.out.println(clientSocket.getInetAddress().toString());
            clientSocket.getInputStream().close();
            clientSocket.getOutputStream().close();
            clientSocket.close();
        } catch (Exception e) {
            System.out.println("Error here");
        }
    }
    public void stop() {
        //Need to make sure threadpool is empty still....
        stop = true;
        threadpool.shutdown();
    }
}