package udp;

import java.net.*;
import java.io.*;

public class UDPClient{
    public static void main(String args[]){ 
		// args give message contents and destination hostname
		DatagramSocket aSocket = null;
		try {
			aSocket = new DatagramSocket(); 
			BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Informe a Mensagem:");
			String entrada = teclado.readLine();
			byte [] m = entrada.getBytes();
			String server = "localhost";
			InetAddress aHost = InetAddress.getByName(server);
			int serverPort = 6789;		                                                 
			DatagramPacket request =
			 	new DatagramPacket(m,  m.length, aHost, serverPort);
			aSocket.send(request);			                        
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);	
			aSocket.receive(reply);
			System.out.println("Reply: " + new String(reply.getData()));	
		}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
		}catch (IOException e){System.out.println("IO: " + e.getMessage());
		}finally {if(aSocket != null) aSocket.close();}
	}		      	
}