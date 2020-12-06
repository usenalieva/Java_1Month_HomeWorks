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

    public int getDamage() {
        return damage;
    }

}
