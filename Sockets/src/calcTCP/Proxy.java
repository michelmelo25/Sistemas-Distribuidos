package calcTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Proxy {
	public static void main(String[] args) {
		try {
			BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));
			String entrada = teclado.readLine();
			ClientTCP cli = new ClientTCP();
			cli.Requisicao(entrada);
//			if(entrada.contains("+")) System.out.println(cli.soma(entrada));
//			else if(entrada.contains("-")) System.out.println(cli.sub(entrada));
//			else if(entrada.contains("/")) System.out.println(cli.div(entrada));
//			else if(entrada.contains("*")) System.out.println(cli.mult(entrada));
		} catch (IOException e){System.out.println("readline:"+e.getMessage());}		
//		if(op == '+') System.out.println(v1+v2);
//		else if(op == '-') System.out.println(v1-v2);
//		else if(op == '/') System.out.println(v1/v2);
//		else if(op == '*') System.out.println(v1*v2);
	}
	

}
