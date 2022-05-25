package com.example.client;

import entity.Person;
import functions.CommandsFunction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        CallService callService = new CallService();
        CommandsFunction cmd = new CommandsFunction();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your command(login/register):");
        String line = keyboard.nextLine();
        String allCommand[] = line.split(" ");
        List<Person> persoane;
        boolean logged = false;
        while(!logged){
            persoane = callService.getPerson();
            if(allCommand[0].equals("login")) {
                if(cmd.loginTest(allCommand,persoane)){
                    logged=true;
                    break;
                } else {
                    System.out.println("User-ul nu exista.");
                }
            }else if(allCommand[0].equals("register")) {
                if(cmd.loginTest(allCommand,persoane)){
                    System.out.println("User existent.");
                }else{
                   if(allCommand.length>1){
                       callService.registerPerson(allCommand[1]);
                       logged=true;
                       break;
                   }
                   else {
                       System.out.println("Trebuie pus si numele.");
                   }
                }
            }
            System.out.println("Enter your command(login/register):");
            line = keyboard.nextLine();
            allCommand = line.split(" ");
        }
        String name = allCommand[1];
        System.out.println("Enter your command:");
        line = keyboard.nextLine();
        allCommand = line.split(" ");

        if(logged){
              while(!(allCommand[0].equals("exit"))){
                  if(allCommand[0].equals("top") && allCommand.length>1){
                      callService.getTop(allCommand[1]);
                  }else if(allCommand[0].equals("send") && allCommand.length>1){
                      callService.sendMessage(allCommand,name);
                  }else if(allCommand[0].equals("read")){
                      callService.readAllMessages();
                  }else if(allCommand.length<2){
                      System.out.println("Comanda nu este completa");
                  }else System.out.println("Camanda nerecunoscuta");
                  System.out.println("Enter your command:");
                  line = keyboard.nextLine();
                  allCommand = line.split(" ");
              }
        }

        System.exit(0);
    }

}
