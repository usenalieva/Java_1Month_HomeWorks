package com.makhabatusen;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	/*  - Create an interface HavingSuperAbility, add 1 abstract method to it
    applySuperAbility (String superAbilityType);
    - Create an abstract Hero class with health, damage, and super type fields
    and implement the HavingSuperAbility interface.
    - Create 3 classes of heroes Magic, Medic, Warrior and inherit them from the class Hero.
    In each class, implement the applySuperAbility method (String superAbilityType) in its own way.
    - In the Main class, create an array of 3 different heroes, then use the superpower of each hero through the loop.*/


        Hero[] heroes = {new Magic(300, 20), new Medic(250, 30),
                new Warrior(240, 25)};

        for (Hero hero : heroes) {
            hero.getInfo();
            System.out.print("Super Ability: ");
            if (hero == heroes[0])
                hero.applySuperAbility("MAGIC CONJURING");
            else if (hero == heroes[1])
                hero.applySuperAbility("MEDICAL HEALING");
            if (hero == heroes[2])
                hero.applySuperAbility("CRITICAL ATTACK");
            System.out.println("___");
        }
    }
}
