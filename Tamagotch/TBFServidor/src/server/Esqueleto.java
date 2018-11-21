package server;

public class Esqueleto {

    private InteradorTamagotchi interadorTamagotchi = new InteradorTamagotchi();


    public String born(String arg){
        Tamagotch tmg = interadorTamagotchi.born(arg);
        return toStringTMG(tmg);
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

    public String feed(String args []){
        Tamagotch tmg = interadorTamagotchi.feed(args);
        return toStringTMG(tmg);
    }

    public String toStringTMG(Tamagotch tmg){
        return tmg.getNome() + " " + tmg.getStatus().getBar() + " " + tmg.getStatus().getFoodBar() + " " + tmg.getStatus().getFunBar() + " " + tmg.getStatus().getCleanBar() + " " + tmg.getStatus().getEnergyBar() + " " + tmg.getStatus().getMessage() + " " + tmg.getFace();
    }
}
