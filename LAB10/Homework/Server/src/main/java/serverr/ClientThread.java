package serverr;

import person.Client;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Locale;

public class ClientThread extends Thread {
    private Socket socket;
    private Client client;
    public ClientThread (Socket socket) {
        this.socket = socket ;
        this.client = new Client();
    }
    public void run () {
        try {
            boolean existent;
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String allCommand[] = in.readLine().split(" ");
                String command = allCommand[0].toLowerCase(Locale.ROOT);
                String response;
                existent = false;
                if(command.equals("register")){
                        if(allCommand.length>1) {
                            FileReader f = new FileReader("target/data/accounts.txt");
                            BufferedReader reader = new BufferedReader(f);
                            String accountName;
                            while((accountName = reader.readLine())!=null){
                                if(accountName.toLowerCase(Locale.ROOT).equals(allCommand[1].toLowerCase(Locale.ROOT))){
                                    response = "Nume existent.";
                                    out.println(response);
                                    out.flush();
                                    existent = true;
                                }
                            }
                            f.close();
                            reader.close();

                            if(!existent) {
                                BufferedWriter writer = new BufferedWriter(new FileWriter("target/data/accounts.txt", true));
                                writer.append('\n');
                                writer.append(allCommand[1].toLowerCase(Locale.ROOT));
                                writer.close();

                                response = "CONECTARE CU SUCCES";
                                out.println(response);
                                out.flush();
                                this.client.setName(allCommand[1].toLowerCase(Locale.ROOT));
                                break;
                            }
                        }else {
                            response = "Comanda incompleta. Trebuie pus numele.";
                            out.println(response);
                            out.flush();
                        }
                    }else
                    if(command.equals("login")){
                        if(allCommand.length>1) {
                            FileReader f = new FileReader("target/data/accounts.txt");
                            BufferedReader reader = new BufferedReader(f);
                            String accountName;
                            while((accountName = reader.readLine())!=null){
                                if(accountName.toLowerCase(Locale.ROOT).equals(allCommand[1].toLowerCase(Locale.ROOT))){
                                    existent = true;
                                }
                            }
                            f.close();
                            reader.close();

                            if(existent) {
                                response = "CONECTARE CU SUCCES";
                                out.println(response);
                                out.flush();
                                this.client.setName(allCommand[1].toLowerCase(Locale.ROOT));
                                f = new FileReader("target/data/friends.txt");
                                reader = new BufferedReader(f);
                                String line;
                                while((line = reader.readLine())!=null){
                                    if(line.split(" ")[0].equals(allCommand[1])){
                                        this.client.setPrieteni(line.split(" ")[1]);
                                    }
                                    else if(line.split(" ")[1].equals(allCommand[1])){
                                        this.client.setPrieteni(line.split(" ")[0]);
                                    }
                                }
                                f.close();
                                reader.close();
                                break;
                            }else{
                                response = "NUMELE NU EXISTA";
                                out.println(response);
                                out.flush();
                            }
                        }else {
                            response = "Comanda incompleta. Trebuie pus numele.";
                            out.println(response);
                            out.flush();
                        }
                    }else{
                        response = "Mai incearca.";
                        out.println(response);
                        out.flush();
                    }
            }

            System.out.println("CONECTAT");
            currentThread().setName(this.client.getName());

            while (true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String allCommand[] = in.readLine().split(" ");
                String command = allCommand[0].toLowerCase(Locale.ROOT);
                System.out.println("Serverul a primit comada: "+ command);
                String response;
                if(command.equals("stop")) {
                    response= "A fost inchis serverul prin comanda stop.";
                    out.println(response);
                    out.flush();
                    socket.close();
                    System.exit(0);
                }else
                if(command.equals("friend")){
                   if(allCommand.length>1 && allCommand.length<11) {
                       int contor = 1, friendshipContor = 0;
                       String[] newFriendShip = new String[10];
                       String stanga, dreapta;
                       while (contor < allCommand.length) {
                           stanga = this.client.getName() + " " + allCommand[contor];
                           dreapta = allCommand[contor] + " " + this.client.getName();
                           FileReader f = new FileReader("target/data/friends.txt");
                           BufferedReader reader = new BufferedReader(f);
                           String line;
                           boolean punemRelatia = true;
                           while ((line = reader.readLine()) != null) {
                               if (line.equals(stanga) || line.equals(dreapta)) {
                                   punemRelatia = false;
                               }
                           }
                           if(punemRelatia) {
                               newFriendShip[friendshipContor] = this.client.getName() + " " + allCommand[contor];
                               friendshipContor++;
                           }
                           contor++;
                       }

                       BufferedWriter writer = new BufferedWriter(new FileWriter("target/data/friends.txt", true));
                       for(String s:newFriendShip) {
                           if(s!=null) {
                               writer.append('\n');
                               writer.append(s);
                               if(s.split(" ")[0]!=this.client.getName()){
                                   this.client.setPrieteni(s.split(" ")[1]);
                               }
                               else this.client.setPrieteni(s.split(" ")[0]);
                           }
                       }
                       writer.close();
                       response = "Prietenii au fost adaugati.";
                   } else {
                       response = "Prea multi sau nici un prieten trimis.";
                   }
                }else if(command.equals("friends")) {
                    response = this.client.getPrieteni().toString();
                }else
                if(command.equals("send")){
                    if(allCommand.length>1) {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("target/data/messages.txt", true));
                        writer.append('\n');
                        writer.append(this.client.getName() + ": ");
                        int contor = 1;
                        while (contor < allCommand.length) {
                            writer.append(allCommand[contor] + " ");
                            contor++;
                        }
                        writer.close();
                        response = "Mesaj trimis.";
                    }else response = "Nu ai pus mesajul.";
                }else
                if(command.equals("read")){
                    FileReader f = new FileReader("target/data/messages.txt");
                    BufferedReader reader = new BufferedReader(f);
                    String message;
                    String splittedMesage[];
                    response = "";
                    while((message = reader.readLine())!=null){
                       splittedMesage = message.split(": ");
                       if(this.client.getPrieteni().contains(splittedMesage[0])){
                           response += splittedMesage[0] + ": " + splittedMesage[1] + "--";
                       }
                    }
                    f.close();
                    reader.close();
                }else {
                    response = "Comanda " + command + " este necunoscuta.";
                }
                out.println(response);
                out.flush();
            }
        } catch (SocketException e){
            System.out.println("Client " + currentThread().getName() + " s-a deconectat.");
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }

    }
}