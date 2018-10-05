package calcTCP;

public class Esqueleto {
    Calc calc;

    public  Esqueleto(){
        calc = new Calc();
    }

    public double soma(String entrada){
        String[] valor = entrada.split("[+]");
        return calc.soma(Double.parseDouble(valor[0]),Double.parseDouble(valor[1]));
    }

    public double sub(String entrada){
        String[] valor = entrada.split("[-]");
        return calc.sub(Double.parseDouble(valor[0]),Double.parseDouble(valor[1]));
    }

    public double mult(String entrada){
        String[] valor = entrada.split("[*]");
        return calc.mult(Double.parseDouble(valor[0]),Double.parseDouble(valor[1]));
    }

    public double div(String entrada){
        String[] valor = entrada.split("[/]");
        return calc.div(Double.parseDouble(valor[0]),Double.parseDouble(valor[1]));
    }
}
