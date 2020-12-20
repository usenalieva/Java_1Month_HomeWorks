package com.makhabatusen;

public class Warrior extends Hero {

    public Warrior(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }

    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(getClass().getSimpleName() + " used his " + superAbilityType + " super ability" +
                " and launched a strike to boss");
    }
}
