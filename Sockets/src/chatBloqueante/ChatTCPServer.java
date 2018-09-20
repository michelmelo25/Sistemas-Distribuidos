package chatBloqueante;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatTCPServer {
	public static void main (String args[]) {

		try{
			int serverPort = 7896; // the server port
			ServerSocket listenSocket = new ServerSocket(serverPort);
			while(true) {
				Socket clientSocket = listenSocket.accept();

                ChatConnection c = new ChatConnection(clientSocket);
			}
		} catch(IOException e) {System.out.println("Listen socket:"+e.getMessage());}
	}
}
class ChatConnection extends Thread {
	DataInputStream in;
	DataOutputStream out;
	Socket clientSocket;
	public ChatConnection(Socket aClientSocket) {
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
                String data = in.readUTF();	                  // read a line of data from the stream
                System.out.println("Porta: "+ clientSocket.getPort() + " | "+data);
                out.writeUTF(mensagem.nextLine());
            }
        }catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		} catch(IOException e) {System.out.println("readline:"+e.getMessage());
		} finally{ try {clientSocket.close();}catch (IOException e){/*close failed*/}}
		

	}
}