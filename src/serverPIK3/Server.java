package serverPIK3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.TimerTask;

public class Server {


    public static void main(String[] args) throws IOException {
    	ServerSocket serverSocket = new ServerSocket(1234);
    
         while (true) {
            new ClientHandler(serverSocket.accept()).start();
         }
     }
}
