package chatBloqueante;

import java.net.*;
import java.io.*;

public class ChatTCPClient {
	public static void main (String args[]) {
		// arguments supply message and hostname
		Socket s = null;
		try{
			int serverPort = 7896;
			String localHoste = "localhost";
			//Variavel para uso do teclado
			BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));
			s = new Socket(localHoste, serverPort);
//			BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));

			DataInputStream in = new DataInputStream( s.getInputStream());
			DataOutputStream out =new DataOutputStream( s.getOutputStream());

			while (true){
				out.writeUTF(teclado.readLine());      	// UTF is a string encoding see Sn. 4.4
				String data = in.readUTF();	    // read a line of data from the stream
				System.out.println(data) ;
			}

		}catch (UnknownHostException e){System.out.println("Socket:"+e.getMessage());
		}catch (EOFException e){System.out.println("EOF:"+e.getMessage());
		}catch (IOException e){System.out.println("readline:"+e.getMessage());
		}finally {if(s!=null) try {s.close();}catch (IOException e){System.out.println("close:"+e.getMessage());}}
     }
}