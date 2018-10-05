package calcTCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Proxy {
	public static void main(String[] args) {
		try {
			while (true){
                BufferedReader teclado =  new BufferedReader(new InputStreamReader(System.in));
                String entrada = teclado.readLine();
                if (entrada.equals("exit")) break;
                ClientTCP cli = new ClientTCP();
                String reposta = cli.Requisicao(entrada);
                System.out.println(reposta);
            }
		} catch (IOException e){System.out.println("readline:"+e.getMessage());}
	}
}
