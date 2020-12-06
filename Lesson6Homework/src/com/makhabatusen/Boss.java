package com.makhabatusen;

public class Boss extends GameEntity {
    private Weapon weapon;

    public Boss(int health, int damage) {
        super(health, damage);
    }


    public Weapon getWeapon() {
        return weapon;
    }


    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }


}
