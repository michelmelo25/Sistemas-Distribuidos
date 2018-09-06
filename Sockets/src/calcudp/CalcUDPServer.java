package calcudp;

import java.net.*;
import java.io.*;

public class CalcUDPServer {
	   public static void main(String args[]){ 
	    	DatagramSocket aSocket = null;
			try{
		    	aSocket = new DatagramSocket(6789); //6789
						// create socket at agreed port
				byte[] buffer = new byte[1000];
	 			while(true){
	 				DatagramPacket request = new DatagramPacket(buffer, buffer.length);
	  				aSocket.receive(request);     
	    			DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(), 
	    				request.getAddress(), request.getPort());
//	    			System.out.println("Print do servidor: " + new String(request.getData()));
	    			aSocket.send(reply);
	    		}
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e) {System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
	   }
	   
	   private void tratamento(String entrada) {
		   String valor1;
		   String valor2;
		   char op;
		   for(int i = 0; i < entrada.length(); i++) {
//			   if(entrada.getChars(0, entrada.length(), dst, dstBegin); != '+') {
//				   
//			   }
		   }
	   }
}
