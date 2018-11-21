package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Tamagotch implements Serializable {
    private String nome;
    private Status status;
    private String face;

    public Tamagotch(String nome, Status status, String face) {
        this.nome = nome;
        this.status = status;
        this.face = face;
    }

    public Tamagotch(JSONObject tama) {
        this.nome = (String) tama.get("nome");
        this.status = (Status) tama.get("status");
        this.face = (String) tama.get("face");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public String toString() {
        return "Tamagotch{" +
                "nome='" + nome + '\'' +
                ", status=" + status +
                ", face='" + face + '\'' +
                '}';
    }

    public JSONObject toJson(){
        JSONObject T = new JSONObject();
        T.put("nome",nome);
        T.put("status",status);
        T.put("face",face);

        return T;
    }
}
