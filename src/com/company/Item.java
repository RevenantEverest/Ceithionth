package com.company;

public class Item {

    private String name;

    private int stamina;
    private int power;
    private int agility;
    private int intellect;

    private int worth;

    public Item(String name, int stamina, int power, int agility, int intellect, int worth) {
        this.name = name;
        this.stamina = stamina;
        this.power = power;
        this.agility = agility;
        this.intellect = intellect;
        this.worth = worth;
    }

    /* Getters */
    public String getItemName() { return name; }
    public int getItemStamina() { return stamina; }
    public int getItemPower() { return power; }
    public int getItemAgility() { return agility; }
    public int getItemIntellect() { return intellect; }
    public int getItemWorth() { return worth; }
    /* END */

    /* Setters */
    public void setItemName(String name) { this.name = name; }
    public void setItemStamina(int stamina) { this.stamina = stamina; }
    public void setItemPower(int power) { this.power = power; }
    public void setItemAgility(int agility) { this.agility = agility; }
    public void setItemIntellect(int intellect) { this.intellect = intellect; }
    public void setItemWorth(int worth) { this.worth = worth; }
    /* END */
}
