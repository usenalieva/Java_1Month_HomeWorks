package com.makhabatusen.players;

import java.util.Random;

public class TrickyBastard extends Hero {
    private int lastHealth;

    public int getLastHealth() {
        return lastHealth;
    }

    public TrickyBastard(int health, int damage) {
        super(health, damage, SuperAbility.PRETENDS_DEAD);
        lastHealth = health;
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {

        Random r = new Random();
        if (r.nextInt(4) == 1) {
            if (this.getHealth() > 0) {
                lastHealth = this.getHealth();
            }
            this.setHealth(0);
            System.out.println("Bastard pretends dead");
        } else {
            this.setHealth(lastHealth);
        }
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {
    }
}