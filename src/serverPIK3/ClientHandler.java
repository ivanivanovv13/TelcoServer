package serverPIK3;


import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    private PrintStream output;

    public ClientHandler(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
        	output=new PrintStream((this.clientSocket).getOutputStream());
            output.println("Connected!");
        	output.println(Location.getCity());
        	output.println(Location.getWeather());
        	output.print(Location.getLat());
        	output.print(Location.getLng());
        } 
        catch(Exception e) {
        	e.printStackTrace();
        }
        finally {
            try {
            	if(clientSocket!=null) {
            		clientSocket.close();
            	}
            	if(output!=null) {
            		output.close();
            	}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

