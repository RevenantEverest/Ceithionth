package com.company;

public class Consumable {

    private String name;
    private int reward;
    private int worth;

    public Consumable(String name, int reward, int worth) {
        this.name = name;
        this.reward = reward;
        this.worth = worth;
    }

    /* Getters */
    public String getName() { return name; }
    public int getReward() { return reward; }
    public int getWorth() { return worth; }
    /* END */

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setReward(int reward) { this.reward = reward; }
    public void setWorth(int worth) { this.worth = worth; }
    /* END */
}
