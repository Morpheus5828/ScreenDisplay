package com.screendisplay.v1;

import com.screendisplay.v1.V1Controller.Slide;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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

    public void sendMessage() throws IOException {
        Socket socket = new Socket();
        SocketAddress socketAddress = new InetSocketAddress(HOST, PORT);
        socket.connect(socketAddress);
        for(Slide slide : this.slides) {
            PrintWriter out = new PrintWriter(
                    new OutputStreamWriter(
                            socket.getOutputStream()));
            out.write(slide.toString());
        }
    }
}
