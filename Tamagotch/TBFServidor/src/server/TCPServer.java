package server;

import org.json.simple.JSONObject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer implements Serializable{

    public static void main (String args[]){
        try{
            int serverPort = 4444; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            System.out.println("Running in port... " + serverPort);
            while(true) {
                Socket clientSocket = listenSocket.accept();
                Despachante despachante = new Despachante();
                ObjectInputStream in = new ObjectInputStream( clientSocket.getInputStream() );
                ObjectOutputStream out = new ObjectOutputStream( clientSocket.getOutputStream() );
                try{
                    JSONObject tmg = (JSONObject) in.readObject();

                    JSONObject t = despachante.run(tmg);
                    out.writeObject(t);
                    out.flush();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage()); e.printStackTrace();}
    }
}

