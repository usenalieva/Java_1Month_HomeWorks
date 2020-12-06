package com.makhabatusen.players;

public class Witcher extends Hero {

    public Witcher(int health, int damage) {
        super(health, damage, SuperAbility.REVIVING_A_HERO);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() == 0 && heroes[i] != this
                        && heroes[i] != heroes[8]) {
                    heroes[i].setHealth(heroes[i].getHealth() + this.getHealth());
                    System.out.println("Witcher revives " + heroes[i].getClass().getSimpleName());
                    this.setHealth(0);

                }
            }

        }
    }
}


