package server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InteradorTamagotchi implements Serializable {
    List<String> feedMessageOptions = new ArrayList<>(){
        {
            add("Que comida boa, Yammy");
            add("Tava ruim mas pelo menos é comida");
            add("Obrigado pela comida");
        }
    };
    List<String> playMessageOptions = new ArrayList<>(){
        {
            add("Hahahaha, que divertido!");
            add("Mas que brincadeira ruim!");
            add("Você não teria coisa melhor não?");
            add("Gostei!");
            add("Você não teria coisa melhor não?");
        }
    };
    List<String> batchMessageOptions = new ArrayList<>(){
        {
            add("Estou limpinho!");
            add("Que banho gostoso");
            add("");
        }
    };
    List<String> letRestMessageOptions = new ArrayList<>(){
        {
            add("Quem foi que apagou a luzes?");
            add("");
            add("");
        }
    };
    List<String> giveAffectionMessageOptions = new ArrayList<>(){
        {
            add("kkkkkkkk, boa piada!");
            add("");
            add("");
        }
    };
    public Tamagotch born(String nome){
        int bar = 100;
        String tamagoth = "";
        //Criando tamagosh, gerando formas

        Random random = new Random();
        for(int i = 0; i < 5; i++){

            if(i == 2){
                tamagoth += nome + "\n";
            }else{
                for(int j = 0; j < nome.length(); j++){
                    tamagoth += random.nextInt(10);
                }
                tamagoth += "\n";
            }

        }
        System.out.println(tamagoth);

        return new Tamagotch(nome, (new Status(bar, bar, bar, bar, bar, "GUGU DADA")), tamagoth);
    }

    public Tamagotch feed(Tamagotch tmg){
//        Tamagotch tmg = toTamagotch(args);
        tmg.getStatus().setMessage("");
        String message = "Que comida boa, Yammy";
        tmg.getStatus().setFoodBar(tmg.getStatus().getFoodBar() + new Random().nextInt(21));
        tmg.getStatus().setEnergyBar(tmg.getStatus().getEnergyBar() - new Random().nextInt(11));
        tmg.getStatus().setCleanBar(tmg.getStatus().getCleanBar() - new Random().nextInt(11));

        return messageStatus(tmg, message);
    }

    public Tamagotch play(Tamagotch tmg){
        tmg.getStatus().setMessage("");
        String message = "Hahahaha, que divertido!";
        tmg.getStatus().setFoodBar(tmg.getStatus().getFoodBar() - new Random().nextInt(11));
        tmg.getStatus().setEnergyBar(tmg.getStatus().getEnergyBar() - new Random().nextInt(11));
        tmg.getStatus().setCleanBar(tmg.getStatus().getCleanBar() - new Random().nextInt(11));
        tmg.getStatus().setFunBar(tmg.getStatus().getFunBar() + new Random().nextInt(21));

        return  messageStatus(tmg, message);
    }
    public Tamagotch bathe(Tamagotch tmg){
        tmg.getStatus().setMessage("");
        String message = "Estou limpinho!";
        tmg.getStatus().setFoodBar(tmg.getStatus().getFoodBar() - new Random().nextInt(6));
        tmg.getStatus().setEnergyBar(tmg.getStatus().getEnergyBar() - new Random().nextInt(6));
        tmg.getStatus().setCleanBar(100);

        return  messageStatus(tmg, message);
    }
    public Tamagotch let_rest(Tamagotch tmg){
        tmg.getStatus().setMessage("");
        String message = "Quem foi que apagou a luzes?";
        tmg.getStatus().setFoodBar(tmg.getStatus().getFoodBar() - new Random().nextInt(11));
        tmg.getStatus().setEnergyBar(100);
        tmg.getStatus().setCleanBar(tmg.getStatus().getCleanBar() - new Random().nextInt(6));
        tmg.getStatus().setFunBar(tmg.getStatus().getFunBar() - new Random().nextInt(31));

        return  messageStatus(tmg, message);
    }
    public Tamagotch give_affection(Tamagotch tmg){
        tmg.getStatus().setMessage("");
        String message = "kkkkkkkk, boa piada!";
        tmg.getStatus().setFoodBar(tmg.getStatus().getFoodBar() - new Random().nextInt(6));
        tmg.getStatus().setEnergyBar(tmg.getStatus().getEnergyBar() - new Random().nextInt(11));
        tmg.getStatus().setFunBar(tmg.getStatus().getFunBar() + new Random().nextInt(11));

        return  messageStatus(tmg, message);
    }
    public Status current_status(Tamagotch tmg){
        return  tmg.getStatus();
    }

    public Tamagotch messageStatus(Tamagotch tmg, String message){
        if(tmg.getStatus().getFoodBar() > 150 || tmg.getStatus().getFunBar() > 150 || tmg.getStatus().getCleanBar() > 150 || tmg.getStatus().getEnergyBar() > 150 || tmg.getStatus().getFoodBar() == 0 || tmg.getStatus().getFunBar() == 0 || tmg.getStatus().getCleanBar() == 0 || tmg.getStatus().getEnergyBar() == 0){
            tmg.getStatus().setMessage("R.I.P.");
            tmg.getStatus().setBar(0);
            tmg.getStatus().setCleanBar(0);
            tmg.getStatus().setEnergyBar(0);
            tmg.getStatus().setFunBar(0);
            tmg.getStatus().setFoodBar(0);

            return tmg;
        }

        if(tmg.getStatus().getFoodBar() > 100 || tmg.getStatus().getFunBar() > 100 || tmg.getStatus().getCleanBar() > 100 || tmg.getStatus().getEnergyBar() > 100){
            message += " Mas estou dodói";
        }

        if(tmg.getStatus().getFoodBar() < 50){
            message+=" e Ainda estou com fome";
        }
        if(tmg.getStatus().getFunBar() < 50){
            message+=" e Preciso me divertir";
        }
        if(tmg.getStatus().getCleanBar() < 50){
            message+=" e Preciso tomar banho";
        }
        if(tmg.getStatus().getEnergyBar() < 50){
            message+=" e Preciso descansar";
        }

        tmg.getStatus().setMessage(message);
        return tmg;
    }

    public Tamagotch toTamagotch (String args[]){
        return new Tamagotch(args[1], new Status(Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4]), Integer.parseInt(args[5]), Integer.parseInt(args[6]),args[7]), args[8]);
    }
}
