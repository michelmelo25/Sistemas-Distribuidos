package chatNaoBloqueante;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TratadorDeMensagemDoCliente {
    private Socket cliente;
    private ChatTCPServer servidor;

    public TratadorDeMensagemDoCliente(Socket cliente, ChatTCPServer servidor) {
        this.cliente = cliente;
        this.servidor = servidor;
    }

    public void run() {
        try(Scanner s = new Scanner(this.cliente.getInputStream())) {
            while (s.hasNextLine()) {
                servidor.distribuiMensagem(this.cliente, s.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
