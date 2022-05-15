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
                if(command.equals("stop")){
                    out.println(command);
                    System.out.println("Clientul a fost oprit deoarece serverul a fost inchis.");
                    System.exit(0);
                }
                System.out.println("Introduceti o comanda: ");
            }

            if(command.equals("exit")){
                System.out.println("Clientul a fost oprit.");
                System.exit(0);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}