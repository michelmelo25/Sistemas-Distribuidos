package InitTamagotch;

import org.json.simple.JSONObject;
import server.Status;
import server.Tamagotch;


public class Proxy {
    TCPCliente tcpCliente;
    JSONObject jsonTamagotch;

    public Proxy(){
        tcpCliente = new TCPCliente();
    }

    public Tamagotch born (String nome){
        System.out.println("Born init");

        JSONObject born = new JSONObject();
        born.put("action", "born");
        born.put("nome", nome);
        System.out.println(born.toString());
        System.out.println(born.get("nome").toString());
        jsonTamagotch = tcpCliente.cliente(born);
//        System.out.println(jsonTamagotch.toString());
//        Tamagotch tamagotch = new Tamagotch(resp);
//        jsonTamagotch.put("nome",tamagotch.getNome());
//        jsonTamagotch.put("status", tamagotch.getStatus());
//        jsonTamagotch.put("face", tamagotch.getFace());

        return new Tamagotch(jsonTamagotch);
    }

    public  Tamagotch Action(String action){
        jsonTamagotch.put("action", action);
        tcpCliente.cliente(jsonTamagotch);
    return null;
    }

    public String tamaString(Tamagotch tamagotch){
        return tamagotch.getNome() + " " + tamagotch.getStatus().getBar() + " " + tamagotch.getStatus().getFoodBar() + " " + tamagotch.getStatus().getFunBar() + " " + tamagotch.getStatus().getCleanBar() + " " + tamagotch.getStatus().getEnergyBar() + " " + tamagotch.getStatus().getMessage() + " " + tamagotch.getFace();
    }

    public Tamagotch TamaTama(String tama){
        String dados[] = tama.split(" ");
        return new Tamagotch(dados[0], new Status(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]), dados[6]), dados[7]);
    }

}
