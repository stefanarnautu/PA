package serverr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;

public class ClientThread extends Thread {
    private Socket socket = null ;
    public ClientThread (Socket socket) { this.socket = socket ; }
    public void run () {
        try {
            int a=0;

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String allCommand[] = in.readLine().split(" ");
                String command = allCommand[0].toLowerCase(Locale.ROOT);

                System.out.println("Serverul a primit comada: "+ command);
                String response = new String();
                if(command.equals("stop")) {
                    response= "A fost inchis serverul prin comanda stop.";
                    out.println(response);
                    out.flush();
                    socket.close();
                    System.exit(0);
                }else
                if(command.equals("register")){
                    response = "A fost trimisa comanda register.";
                }else
                if(command.equals("login")){
                    response = "A fost trimisa comanda login.";
                }else
                if(command.equals("friend")){
                    response = "A fost trimisa comanda friend.";
                }else
                if(command.equals("send")){
                    response = "A fost trimisa comanda send.";
                }else
                if(command.equals("read")){
                    response = "A fost trimisa comanda read.";
                }else {
                    response = "Comanda " + command + " este necunoscuta.";
                }
                out.println(response);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }

    }
}