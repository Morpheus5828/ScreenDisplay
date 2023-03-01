package com.screendisplay.v1;

import com.screendisplay.v1.V1Controller.Slide;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.List;

public class Sender {
    private final int PORT = 1234;
    private final String HOST = "localhost";
    private List<Slide> slides;

    public Sender(List<Slide> slides) {
        this.slides = slides;
    }

    public void sendMessage() {
        System.out.println(slides.get(0));
        try (Socket socket = new Socket(HOST, PORT);) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            for(Slide slide : this.slides) {
                String s = slide.toString();
                writer.println(s);
            }


        } catch (Exception e) {
            System.err.println("ERROR - Connection Failed with Receiver");
        }
    }
}
