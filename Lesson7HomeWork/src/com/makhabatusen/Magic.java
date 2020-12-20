package com.makhabatusen;

public class Magic extends Hero {

    public Magic(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }
    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(getClass().getSimpleName() + " used his " + superAbilityType + " super ability" +
                " and drugged the boss");
    }
}
