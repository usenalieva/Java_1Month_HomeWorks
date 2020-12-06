package com.makhabatusen;

public class Hero {

    /*   MAIN TASK:
    Create a class "Hero" with private fields health, damage and superpowers. Write 2 different
    constructor to create an object. In one constructor all fields are set, in the other only health and damage.
    Add getters for all fields to the Hero class. */

    private int health;
    private int damage;
    private String superpower;

    public Hero(int health, int damage, String superpower) {
        this.superpower = superpower;
        this.health = health;
        this.damage = damage;
    }

    public Hero(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }


    public int getDamage() {
        return damage;
    }

    public String getSuperpower() {
        return superpower;
    }
}

