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
	    			float resultado = Calculo(request.getData());
	    			aSocket.send(reply);
	    		}
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e) {System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
	   }
	   
	   private float Calculo(String entrada) {
		   String valor1 = "";
		   String valor2 = "";
		   for(int i = 0; i < entrada.length(); i++) {
			   if(entrada.charAt(i) != '+') {
				   if(entrada.charAt(i) != '-') {
					   if(entrada.charAt(i) != '*') {
						   if(entrada.charAt(i) != '/') {
							   valor1 += entrada.charAt(i);
						   }else {
							   valor2 = entrada.substring(i+1, entrada.length());
							   float resultado;
							   resultado = Float.parseFloat(valor1) / Float.parseFloat(valor2);
							   return resultado;
						   }
					   }else {
						   valor2 = entrada.substring(i+1, entrada.length());
						   float resultado;
						   resultado = Float.parseFloat(valor1) * Float.parseFloat(valor2);
						   return resultado;
					   }
				   }else {
					   valor2 = entrada.substring(i+1, entrada.length());
					   float resultado;
					   resultado = Float.parseFloat(valor1) - Float.parseFloat(valor2);
					   return resultado;
				   }
			   }else {
				   valor2 = entrada.substring(i+1, entrada.length());
				   float resultado;
				   resultado = Float.parseFloat(valor1) + Float.parseFloat(valor2);
				   return resultado;
			   }
		   }
	   }
}
