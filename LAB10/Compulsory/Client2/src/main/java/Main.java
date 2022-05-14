import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        Socket socket = new Socket(serverAddress, PORT);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String command="";
        System.out.println("Introduceti o comanda: ");
        try{
            while(!( command = reader.readLine()).equals("exit")){
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println(command);
                String response = in.readLine();
                System.out.println(response);
                if(command.equals("exit")){
                    System.out.println("Client stopped");
                    System.exit(0);
                }
                if(command.equals("stop")){
                    System.out.println("Server Stopped");
                    out.println(command);
                    System.exit(0);
                }
                System.out.println("Introduceti o comanda: ");
            }


        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }

        PrintWriter outWhile = new PrintWriter(socket.getOutputStream(), true);
        outWhile.println("exit");
        System.out.println("Client stopped.");
    }
}