package com.makhabatusen.players;

public class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {

        int random = (int)((Math.random()*4)+2);
        this.setDamage(this.getHealth()*random);
        System.out.println("Warrior multiplies his Damage by: " + random);
    }

}
