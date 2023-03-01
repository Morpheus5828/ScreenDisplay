package com.screendisplay.v1;

/* Receive FXML file to display it on screen */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Receiver {
    private static final int PORT = 1234;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("SERVER IS LISTENING ON PORT " + PORT);
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("New Client connected");
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                String text = "";
                String result = "";
                while((text = reader.readLine()) != null)
                    result += text;

                writer.println(result);
                System.out.println(result);
                socket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
