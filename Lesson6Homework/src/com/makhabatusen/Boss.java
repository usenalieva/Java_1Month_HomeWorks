package com.makhabatusen;

public class Boss extends GameEntity {
    private Weapon weapon;

    public Boss(int health, int damage, Weapon weapon) {
        super(health, damage);
        this.weapon = weapon;
    }

    @Override
    public void info() {
        super.info();
        System.out.println( "weapon: " + weapon.getWeaponName() + " " +  weapon.getWeaponType());
    }
}
