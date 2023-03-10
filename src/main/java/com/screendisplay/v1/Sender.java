package com.screendisplay.v1;

import com.screendisplay.v1.V1Controller.Slide;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

public class Sender {
    private final int PORT = 1234;
    private final String HOST = "192.168.1.30";

    public Sender() {
        //todo a envoyer le fichier
    }

    public void sendMessage() {
        try (Socket socket = new Socket(HOST, PORT);) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
            writer.println(",");
            //writer.println();
        } catch (Exception e) {
            System.err.println("ERROR - Connection Failed with Receiver");
        }
    }
}
