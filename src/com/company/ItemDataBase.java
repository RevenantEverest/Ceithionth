package com.company;

public class ItemDataBase {

    //Weapons
    private Weapon ShadowAxeOfStrength = new Weapon("Shadow Axe of Strength", 10, 10, 10,10 ,45);
    private Weapon FireStaffOfIntellect = new Weapon("Fire Staff of Intellect", 10, 10, 10, 10, 30);
    private Weapon LongBowOfAlchemy = new Weapon("Long Bow of Alchemy", 10, 10, 10, 10, 25);
    private Weapon GreatSwordOfDisease = new Weapon("Great Sword of Disease", 10, 10, 10, 10, 45);

    //Armor
    private Armor HelmetOfAgility = new Armor("Helmet of Agility", 10, 10, 10, 10, 32);
    private Armor PantsOfTrueShot = new Armor("Pants of True Shot", 10, 10, 10, 10, 40);

    //Consumable
    private Consumable PotionOfAgility = new Consumable("Potion of Agility", 10, 10);

    public Weapon[] weapons = {ShadowAxeOfStrength, FireStaffOfIntellect, LongBowOfAlchemy, GreatSwordOfDisease};

    public Consumable[] consumables = {};

    public Armor[] armor = {};

    public Weapon[] getWeapons() { return weapons; };
}
