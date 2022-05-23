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
        CallService c = new CallService();
        CommandsFunction cmd = new CommandsFunction();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your command(login/register):");
        String line = keyboard.nextLine();
        String allCommand[] = line.split(" ");
        boolean logged = false;
        while(!logged){
            List<Person> persoane = c.getPerson();
            if(allCommand[0].equals("login")) {
                if(cmd.loginTest(allCommand,persoane)){
                    break;
                } else {
                    System.out.println("User-ul nu exista.");
                }
            }else if(allCommand[0].equals("register")) {
                if(cmd.loginTest(allCommand,persoane)){
                    System.out.println("User existent.");
                }else{
                   if(allCommand.length>1){
                       c.registerPerson(allCommand[1]);
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
    }

}
