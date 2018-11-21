package server;

import org.json.simple.JSONObject;

public class Despachante extends Thread {

    public JSONObject run(JSONObject in){
//        Tamagotch data =  new Tamagotch(in);
//        String action = in.get("action").toString();
        System.out.println(in.get("action").toString());
        Esqueleto esqueleto = new Esqueleto();

        System.out.println("oi");
        if(in.get("action").equals("born")){
            System.out.println("Born...");
            System.out.println(in.toString());
            JSONObject tamreture = esqueleto.born(in);
             return tamreture;
        }else if(in.get("action").equals("feed")){
            return esqueleto.feed(in);
        }else{
            System.out.println("Algo deu errado!");
        }
        return null;
    }
}
