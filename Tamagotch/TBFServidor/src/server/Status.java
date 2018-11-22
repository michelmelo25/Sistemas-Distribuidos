package server;

import org.json.simple.JSONObject;

import java.io.Serializable;

public class Status implements Serializable {
    private int bar;
    private int foodBar;
    private int funBar;
    private int cleanBar;
    private int energyBar;
    private String message;

    public Status(int bar, int foodBar, int funBar, int cleanBar, int energyBar, String message) {
        this.bar = bar;
        this.foodBar = foodBar;
        this.funBar = funBar;
        this.cleanBar = cleanBar;
        this.energyBar = energyBar;
        this.message = message;
    }

    public Status(JSONObject status) {
        this.bar = (int) status.get("bar");
        this.foodBar = (int) status.get("foodBar");
        this.funBar = (int) status.get("funBar");
        this.cleanBar = (int) status.get("cleanBar");
        this.energyBar = (int) status.get("energyBar");
        this.message = (String) status.get("message");
    }

    public int getBar() {
        return bar;
    }

    public void setBar(int bar) {
        this.bar = bar;
    }

    public int getFoodBar() {
        return foodBar;
    }

    public void setFoodBar(int foodBar) {
        this.foodBar = foodBar;
    }

    public int getFunBar() {
        return funBar;
    }

    public void setFunBar(int funBar) {
        this.funBar = funBar;
    }

    public int getCleanBar() {
        return cleanBar;
    }

    public void setCleanBar(int cleanBar) {
        this.cleanBar = cleanBar;
    }

    public int getEnergyBar() {
        return energyBar;
    }

    public void setEnergyBar(int energyBar) {
        this.energyBar = energyBar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Status{" +
                "bar=" + bar +
                ", foodBar=" + foodBar +
                ", funBar=" + funBar +
                ", cleanBar=" + cleanBar +
                ", energyBar=" + energyBar +
                ", message='" + message + '\'' +
                '}';
    }

    public JSONObject toJson(){
        JSONObject states = new JSONObject();
        states.put("bar", bar);
        states.put("foodBar", foodBar);
        states.put("funBar", funBar);
        states.put("cleanBar", cleanBar);
        states.put("energyBar", energyBar);
        states.put("message", message);
        return states;
    }
}
