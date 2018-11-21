package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main (String args[]) {
        DataInputStream in;
        DataOutputStream out;
        try{
            int serverPort = 4444; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Running");
            while(true) {
                Socket clientSocket = listenSocket.accept();
                Despachante despachante = new Despachante();
                in = new DataInputStream( clientSocket.getInputStream());
                out = new DataOutputStream( clientSocket.getOutputStream());
                System.out.println("Server");
                out.writeUTF(despachante.run(in.readLine()));

            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

