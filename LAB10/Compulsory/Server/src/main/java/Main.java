import serverr.ClientThread;

import java.io.*;
import java.net.*;
import java.util.Date;

public class Main {
    public static final int PORT = 8100;
    public Main(){
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println ("Ooops... " + e);
        }
    }
    public static void main ( String [] args ) throws IOException {
        Main server=new Main();
    }
}