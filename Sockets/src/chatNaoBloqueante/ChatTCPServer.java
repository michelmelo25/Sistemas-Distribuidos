package chatNaoBloqueante;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ChatTCPServer {
    public static void main (String args[]) {
//        Queue<Socket> filaSocket = new LinkedList<>();
        try{
            int serverPort = 7896; // the server port
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while(true) {
                Socket clientSocket = listenSocket.accept();
//                filaSocket.add(clientSocket);
                Connection c = new Connection(clientSocket);
            }
        } catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
    }
}

class Connection extends Thread {
    DataInputStream in;
    DataOutputStream out;
    Socket clientSocket;
    public Connection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream( clientSocket.getInputStream());

            out =new DataOutputStream( clientSocket.getOutputStream());
            this.start();
        } catch(IOException e) {System.out.println("ChatConnection:"+e.getMessage());}
    }
    public void run(){
        Scanner mensagem = new Scanner(System.in);
        try {			                 // an echo server

            while (true){

                String data = in.readUTF();	                  // read a line of data from the strea
                System.out.println("Porta: "+ clientSocket.getLocalPort() + " | "+data);
                out.writeUTF(mensagem.nextLine());
//                if (System.in.available() > 0){
//                    //p += System.in.;
//
//                }else{
//                }

            }
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
        } catch(IOException e) {System.out.println("readline:"+e.getMessage());
        } finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}


    }
}
