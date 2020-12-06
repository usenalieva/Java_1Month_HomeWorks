package com.makhabatusen;

public class Hero implements HavingSuperAbility {
    private int health;
    private int damage;


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

    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(superAbilityType);
    }

    @Override
    public void getInfo() {
        System.out.println(getClass().getSimpleName() + " Health: " + health + " " + " Damage: " +  damage);
    }
}

