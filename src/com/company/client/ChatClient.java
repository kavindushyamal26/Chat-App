package com.company.client;

import java.io.*;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.start();
        client.sendMessage("Hello from the client");

        while (true) {
            Scanner input = new Scanner(System.in);
            String m = input.nextLine();
            client.sendMessage(m);
        }

//        client.sendMessage("Hello from the client");
//        client.sendMessage("How are you");
//        client.sendMessage("I'm fine");
//        client.sendMessage("Thank You!");
//        client.sendMessage("exit");

    }
}

