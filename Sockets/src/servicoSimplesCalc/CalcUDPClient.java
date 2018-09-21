package servicoSimplesCalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalcUDPClient {
	   public static void main(String args[]){ 
			// args give message contents and destination hostname
			DatagramSocket aSocket = null;
			try {
				aSocket = new DatagramSocket(); 
				BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Qual tipo de calculadora vc deseja operar? [0 - Simples | 1 - Exponencial]:");
                int type = new Scanner(System.in).nextInt();
//                String entrada = String.valueOf(type);
                while (type != 0 && type != 1){
                    System.out.println("Calculadora invelida, selecione novamente:");
                    System.out.println("[0 - Simples | 1 - Exponencial]");
                    type = new Scanner(System.in).nextInt();
                }
                while (true){
                    String entrada = String.valueOf(type);
                    System.out.println("Informa a operação:");
                    entrada += teclado.readLine();
                    if (entrada.equals(String.valueOf(type)+"exit")) break;
                    String server = "localhost";
                    InetAddress aHost = InetAddress.getByName(server);
                    int serverPort = 6789;
                    DatagramPacket request =
                            new DatagramPacket(entrada.getBytes(),  entrada.length(), aHost, serverPort);
                    aSocket.send(request);
                    byte[] buffer = new byte[1000];
                    DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
                    aSocket.receive(reply);
                    System.out.println("Reply: " + new String(reply.getData()));
                }
			}catch (SocketException e){System.out.println("Socket: " + e.getMessage());
			}catch (IOException e){System.out.println("IO: " + e.getMessage());
			}finally {if(aSocket != null) aSocket.close();}
		}	
}
