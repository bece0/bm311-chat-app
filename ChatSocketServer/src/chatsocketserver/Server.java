/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsocketserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ASUS
 */
public class Server {

    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream streamIn = null;
    private static int port;

    public Server(int port) {
        this.port = port;
    }

    public void StartServer() {

        try {
            System.out.println("Binding to port " + port + ", please wait  ...");
            server = new ServerSocket(port);
            System.out.println("Server started: " + server);
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted: " + socket);

            streamIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            boolean done = false;
            while (!done) {
                try {
                    String line = streamIn.readUTF();
                    System.out.println(line);
                    
                    
                    //done = line.equals(".bye");
                } catch (IOException ioe) {
                    done = true;
                }
            }

            if (socket != null) {
                socket.close();
            }
            if (streamIn != null) {
                streamIn.close();
            }

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

    }

}
