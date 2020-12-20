package com.makhabatusen;

public class Medic extends Hero {

    public Medic(int health, int damage, String superAbility) {
        super(health, damage, superAbility);
    }
    @Override
    public void applySuperAbility(String superAbilityType) {
        System.out.println(getClass().getSimpleName() + " used his " + superAbilityType + " super ability" +
                " and healed the hero");
    }
}
