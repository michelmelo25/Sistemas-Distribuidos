package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Esqueleto implements Serializable {

    private InteradorTamagotchi interadorTamagotchi = new InteradorTamagotchi();


    public JSONObject born(JSONObject arg){
        System.out.println(arg.toString());
        Tamagotch tmg = interadorTamagotchi.born(arg.get("nome").toString());
        return tmg.toJson();
    }

//    public String adc(String args[]){
//        double result = interadorTamagotchi.adc(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
//        return "" + result;
//    }
//
//    public String sub(String args []){
//        double result = interadorTamagotchi.sub(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
//        return "" + result;
//    }
//
//    public String mul(String args []){
//        double result = interadorTamagotchi.mul(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
//        return "" + result;
//    }
//
//    public String div(String args []){
//        double result = interadorTamagotchi.div(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
//        return "" + result;
//    }

    public JSONObject feed(JSONObject args){
        Tamagotch tmg = interadorTamagotchi.feed(new Tamagotch(args));
        return tmg.toJson();
    }

    public JSONObject play(JSONObject args){
        Tamagotch tmg = interadorTamagotchi.play(new Tamagotch(args));
        return tmg.toJson();
    }

    public JSONObject bathe(JSONObject args){
        Tamagotch tmg = interadorTamagotchi.bathe(new Tamagotch(args));
        return tmg.toJson();
    }

    public JSONObject left_rest(JSONObject args){
        Tamagotch tmg = interadorTamagotchi.left_rest(new Tamagotch(args));
        return tmg.toJson();
    }

    public JSONObject give_affection(JSONObject args){
        Tamagotch tmg = interadorTamagotchi.give_affection(new Tamagotch(args));
        return tmg.toJson();
    }

    public JSONObject current_status(JSONObject args){
        Status stt = interadorTamagotchi.current_status(new Tamagotch(args));
        return stt.toJson();
    }

    public String toStringTMG(Tamagotch tmg){
        return tmg.getNome() + " " + tmg.getStatus().getBar() + " " + tmg.getStatus().getFoodBar() + " " + tmg.getStatus().getFunBar() + " " + tmg.getStatus().getCleanBar() + " " + tmg.getStatus().getEnergyBar() + " " + tmg.getStatus().getMessage() + " " + tmg.getFace();
    }
}
