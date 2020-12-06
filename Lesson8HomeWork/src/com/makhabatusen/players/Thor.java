package com.makhabatusen.players;

import java.util.Random;

public class Thor extends Hero {


    public Thor(int health, int damage) {
        super(health, damage, SuperAbility.ENEMY_STUNNING);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {
        Random r = new Random();
        boss.set_Stunned(r.nextInt(3) == 1);
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {

    }
}



