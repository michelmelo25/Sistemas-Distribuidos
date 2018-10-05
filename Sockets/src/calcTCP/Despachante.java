package calcTCP;

public class Despachante {
    Esqueleto esqueleto;

    public Despachante(){
        esqueleto = new Esqueleto();
    }

	public String Despachar(String entrada) {
			if(entrada.contains("+")) return String.valueOf(esqueleto.soma(entrada));
			else if(entrada.contains("-")) return String.valueOf(esqueleto.sub(entrada));
			else if(entrada.contains("/")) return String.valueOf(esqueleto.div(entrada));
			else if(entrada.contains("*")) return String.valueOf(esqueleto.mult(entrada));
			return null;
	}
}
