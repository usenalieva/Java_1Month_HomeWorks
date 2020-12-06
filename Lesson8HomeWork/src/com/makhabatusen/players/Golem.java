package com.makhabatusen.players;

public class Golem extends Hero {

    public Golem(int health, int damage) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperAbilityBeforeRound(Boss boss, Hero[] heroes) {

    }

    @Override
    public void applySuperAbilityAfterRound(Boss boss, Hero[] heroes) {
        int percentageOfAttack = (int) (Math.random() * ((100 - 1) + 1) + 1);
        if (this.getHealth() > 0) {

            boss.setHealth(boss.getHealth() - (this.getDamage() * percentageOfAttack / 100));

            System.out.println("Golem adds " + percentageOfAttack
                    + "% to his Damage");

        }
    }
}