package com.company;

public class EnemyStats {
    private String name;

    private int baseHealth;
    private int health;
    private int maxHealth;

    private int power;
    private int stamina;
    private int agility;
    private int intellect;

    public EnemyStats(String name, int baseHealth, int health, int maxHealth, int power, int stamina, int agility, int intellect) {
        this.name = name;
        this.baseHealth = baseHealth;
        this.health = health;
        this.maxHealth = maxHealth;
        this.power = power;
        this.stamina = stamina;
        this.agility = agility;
        this.intellect = intellect;
    }

    /* Getters */
    public String getName() { return name; }
    public int getBaseHealth() { return baseHealth; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getPower() { return power; }
    public int getStamina() { return stamina; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    /* END */

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setBaseHealth(int baseHealth) { this.baseHealth = baseHealth; }
    public void setHealth(int health) { this.health = health; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setPower(int power) { this.power = power; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntellect(int intellect) { this.intellect = intellect; }
    /* END */
}
