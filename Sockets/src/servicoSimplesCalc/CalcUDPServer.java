package servicoSimplesCalc;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class CalcUDPServer {
	   public static void main(String args[]){ 
	    	DatagramSocket aSocket = null;
			try{
		    	aSocket = new DatagramSocket(6789); //6789
						// create socket at agreed port
				byte[] buffer = new byte[1000];
	    			System.out.println("Servidor Rodando");
                while(true){
                    DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                    aSocket.receive(request);
                    String entrada = new String(request.getData());

                    float resultado = 0;
                    if(entrada.charAt(0) == '0'){
                        resultado = CalcSimples(entrada.substring(1,entrada.length()));
                    }else if(entrada.charAt(0) == '1'){
                        resultado = CalcExponent(entrada.substring(1,entrada.length()));
                    }
	    			String send = String.valueOf(resultado);
//					DatagramPacket reply = new DatagramPacket(request.getData(), request.getLength(),
//							request.getAddress(), request.getPort());
					DatagramPacket reply = new DatagramPacket(send.getBytes(), send.length(),
							request.getAddress(), request.getPort());
	    			aSocket.send(reply);
	    		}
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e) {System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
	   }

	   public static float CalcSimples(String entrada){
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
                               return Float.parseFloat(valor1) / Float.parseFloat(valor2);
                           }
                       }else {
                           valor2 = entrada.substring(i+1, entrada.length());
                           return Float.parseFloat(valor1) * Float.parseFloat(valor2);
                       }
                   }else {
                       valor2 = entrada.substring(i+1, entrada.length());
                       return Float.parseFloat(valor1) - Float.parseFloat(valor2);
                   }
               }else {
                   valor2 = entrada.substring(i+1, entrada.length());
                   return Float.parseFloat(valor1) + Float.parseFloat(valor2);
               }
           }
           return 0;
       }

       public static float CalcExponent(String entrada){
           String valor1 = "";
           String valor2 = "";
           for(int i = 0; i < entrada.length(); i++) {
               if(entrada.charAt(i) != '+') {
                   if(entrada.charAt(i) != '-') {
                       if(entrada.charAt(i) != '*') {
                           if(entrada.charAt(i) != '/') {
                               if(entrada.charAt(i) != '^'){
                                   valor1 += entrada.charAt(i);
                               }else{
                                   valor2 = entrada.substring(i+1, entrada.length());
                                   return (float)Math.pow(Float.parseFloat(valor1),Float.parseFloat(valor2));
                               }
                           }else {
                               valor2 = entrada.substring(i+1, entrada.length());
                               return Float.parseFloat(valor1) / Float.parseFloat(valor2);
                           }
                       }else {
                           valor2 = entrada.substring(i+1, entrada.length());
                           return Float.parseFloat(valor1) * Float.parseFloat(valor2);
                       }
                   }else {
                       valor2 = entrada.substring(i+1, entrada.length());
                       return Float.parseFloat(valor1) - Float.parseFloat(valor2);
                   }
               }else {
                   valor2 = entrada.substring(i+1, entrada.length());
                   return Float.parseFloat(valor1) + Float.parseFloat(valor2);
               }
           }
           return 0;
       }

}
