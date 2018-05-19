package com.company;

public class PlayerStats {

    private String name;
    private String className;

    private int baseHealth;
    private int health;
    private int maxHealth;

    private int power;
    private int stamina;
    private int agility;
    private int intellect;

    private int exp;
    private int level;
    private int gold;

    public PlayerStats(String name, String className, int baseHealth, int health, int maxHealth, int power, int stamina, int agility, int intellect, int exp, int level, int gold) {
     this.name = name;
     this.className = className;
     this.baseHealth = baseHealth;
     this.health = health;
     this.maxHealth = maxHealth;
     this.power = power;
     this.stamina = stamina;
     this.agility = agility;
     this.intellect = intellect;
     this.exp = exp;
     this.level = level;
     this.gold = gold;
    }

    /* Getters */
    public String getName() { return name; }
    public String getClassName() { return className; }
    public int getBaseHealth() { return baseHealth; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getPower() { return power; }
    public int getStamina() { return stamina; }
    public int getAgility() { return agility; }
    public int getIntellect() { return intellect; }
    public int getExp() { return exp; }
    public int getLevel() { return level; }
    public int getGold() { return gold; }
    /* END */

    /* Setters */
    public void setName(String name) { this.name = name; }
    public void setClassName(String className) { this.className = className; }
    public void setBaseHealth(int baseHealth) { this.baseHealth = baseHealth; }
    public void setHealth(int health) { this.health = health; }
    public void setMaxHealth(int maxHealth) { this.maxHealth = maxHealth; }
    public void setPower(int power) { this.power = power; }
    public void setStamina(int stamina) { this.stamina = stamina; }
    public void setAgility(int agility) { this.agility = agility; }
    public void setIntellect(int intellect) { this.intellect = intellect; }
    public void setExp(int exp) { this.exp = exp; }
    public void setLevel(int level) { this.level = level; }
    public void setGold(int gold) { this.gold = gold; }
    /* END */
}
