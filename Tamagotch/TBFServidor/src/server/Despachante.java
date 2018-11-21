package server;

public class Despachante extends Thread {

    public String run(String in){
            String data = in;
            String dataB [] = data.split(" ");
            Esqueleto esqueleto = new Esqueleto();

            System.out.println("oi");
            if(dataB[0].equals("born")){



                data = esqueleto.born(dataB[1]);

            }else if(dataB[0].equals("feed")){

                data = esqueleto.feed(dataB);
            }else{
                System.out.println("Algo deu errado!");
            }

            return data;




    }
}
