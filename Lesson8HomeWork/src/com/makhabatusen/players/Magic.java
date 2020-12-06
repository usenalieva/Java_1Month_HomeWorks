package com.makhabatusen.players;

import java.util.Random;

public class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, SuperAbility.BOOST);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {

        Random r = new Random();
        int random = r.nextInt(100)+1;

        for (Hero hero : heroes) {
            if (this.getHealth() > 0 && hero.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - (hero.getDamage() * random / 100));

            }
        }
        System.out.println("Magic adds " + random + "% to Heroes Damage");

    }
}

