package com.makhabatusen;


public class Main {

    public static void main(String[] args) {
	/*  - Create an interface HavingSuperAbility, add 1 abstract method to it
    applySuperAbility (String superAbilityType);
    - Create an abstract Hero class with health, damage, and superAbility type fields
    and implement the HavingSuperAbility interface.
    - Create 3 classes of heroes Magic, Medic, Warrior and inherit them from the class Hero.
    In each class, implement the applySuperAbility method (String superAbilityType) in its own way.
    - In the Main class, create an array of 3 different heroes, then use the superpower of each hero through the loop.*/


        Hero[] heroes = {new Magic(300, 20, "MAGICAL"),
                new Medic(250, 30, "MEDICAL"),
                new Warrior(240, 25, "PHYSICAL")};

        for (Hero hero : heroes) {
            hero.getInfo();
            hero.applySuperAbility(hero.getSuperAbilityType());
            System.out.println("___");
        }
    }
}
