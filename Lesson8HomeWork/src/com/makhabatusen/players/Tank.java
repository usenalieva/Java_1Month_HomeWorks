package com.makhabatusen.players;

public class Tank extends Hero {


    public Tank(int health, int damage) {
        super(health, damage, SuperAbility.TAKING_ONE_FIFTH_OF_DAMAGE);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {
    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {
        int oneFifthOfBossDamage = boss.getDamage() / 5;
        if (!boss.is_Stunned()) {
            for (Hero hero : heroes) {
                if (hero != this && hero.getHealth() > 0) {
                    hero.setHealth(hero.getHealth() + oneFifthOfBossDamage);
                }
            }
            this.setHealth(this.getHealth() - oneFifthOfBossDamage * heroes.length + oneFifthOfBossDamage);
            System.out.println("Tank takes 1/5 of Boss Damage towards other heroes");
        }
    }
}
