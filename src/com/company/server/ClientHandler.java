package com.company.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private Socket client;
    public ClientHandler(Socket socket) {
        this.client=socket;
    }
    @Override
    public void run() {

        try {
            Thread.sleep(20000); //wait for 20 second before the execute thr rest of the code

            //received some data
            InputStream inputStream=this.client.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            DataOutputStream dataOutputStream = new DataOutputStream(client.getOutputStream());

            //continuous reading data from client
            String inputdata;
            while ((inputdata =bufferedReader.readLine()) != null){
                System.out.println("Client says : "+ inputdata);

                //send data to client
                // can use scanner class to capture user input

                       Scanner input = new Scanner(System.in);
                       String m = input.nextLine();
                       dataOutputStream.writeBytes(m+"\n");


//                switch (inputdata){
//                    case "Hello from the client": dataOutputStream.writeBytes("Hello from the server...\n");
//                        break;
//                    case "How are you": dataOutputStream.writeBytes("I'm fine whatsup?...\n");
//                        break;
//                    case "I'm fine": dataOutputStream.writeBytes("ok good to know..\n");
//                        break;
//                    case "Thank You!": dataOutputStream.writeBytes("You are welcome!..\n");
//                        break;
//                    default: dataOutputStream.writeBytes("I didnt get that");
//                }
//               if(inputdata.equals("exit")){
//                    break;
//                }
            }
            this.client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }
    // Two ways to create a thread in java
    // 1. Extend the class using Thread Super Class
    // 2. Implement the Class using Runnable interface
}
