package serverr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            int a=0;

            PrintWriter out = new PrintWriter(socket.getOutputStream());


            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String command = in.readLine();
                System.out.println("Server received the request: "+ command);
                String response = new String();
                if(command.equals("stop")) {
                    response= "Server Stopped.";
                    out.println(response);
                    out.flush();
                    socket.close();
                    System.exit(0);
                }
                if(command.equals("register")){
                    response = "A fost trimisa comanda register";
                }
                if(command.equals("login")){
                    response = "A fost trimisa comanda login";
                }
                if(command.equals("friend")){
                    response = "A fost trimisa comanda friend";
                }
                if(command.equals("send")){
                    response = "A fost trimisa comanda send";
                }
                if(command.equals("read")){
                    response = "A fost trimisa comanda read";
                }
                out.println(response);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }

    }
}