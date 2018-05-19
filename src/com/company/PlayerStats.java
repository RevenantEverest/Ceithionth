package com.company;

public class PlayerStats {

    private String name;

    private int baseHealth;
    private int health;

    private int power;
    private int stamina;
    private int agility;
    private int intellect;

    private int exp;
    private int level;

    public PlayerStats(String name,int baseHealth, int health,int power, int stamina, int agility, int intellect, int exp, int level) {
     this.name = name;
     this.baseHealth = baseHealth;
     this.health = health;
     this.power = power;
     this.stamina = stamina;
     this.agility = agility;
     this.intellect = intellect;
     this.exp = exp;
     this.level = level;
    }

    /* Getters */
    public String getName() { return name; }
    public int getBaseHealth() { return baseHealth; }
    public int getHealth() { return health; }
    public int getPower() { return power; }
    public int getStamina() { return stamina; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    public int getExp() { return exp; }
    public int getLevel() { return level; }
    /* END */

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setBaseHealth(int baseHealth) { this.baseHealth = baseHealth; }
    public void setHealth(int health) { this.health = health; }
    public void setPower(int power) { this.power = power; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntellect(int intellect) { this.intellect = intellect; }
    public void setExp(int exp) { this.exp = exp; }
    public void setLevel(int level) { this.level = level; }
    /* END */
}
