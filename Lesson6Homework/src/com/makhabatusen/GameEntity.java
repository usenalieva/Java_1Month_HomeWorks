package com.makhabatusen;

public class GameEntity {
private int health;
private int damage;

    public GameEntity(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void  info() {
        System.out.println(getClass().getSimpleName() + " info: " +
                "\nhealth: " +   health +
                "\ndamage: " +   damage);
    }
}
