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
            for (Hero hero : heroes) {
                if (hero.getHealth() == 0 && hero != this
                        && !hero.getClass().getSimpleName().equals("TrickyBastard")) {
                    hero.setHealth(hero.getHealth() + this.getHealth());
                    System.out.println("Witcher revives " + hero.getClass().getSimpleName());
                    this.setHealth(0);

                }
            }

        }
    }
}


