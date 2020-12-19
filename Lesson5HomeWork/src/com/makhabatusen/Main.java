package com.makhabatusen;

public class Main {


    public static void main(String[] args) {

        /* MAIN TASK:
         In the Main class, create 1 instance of the boss and set all the properties (values for the fields) to it.
        Then print out all the information about the boss. */

        Boss boss = new Boss();
        boss.setHealth(700);
        boss.setBossDefenceType("Random");
        boss.setDamage(50);
        boss.bossInfo();


         /* ADDITIONAL TASK:
    Add a method in the Main class called createHeroes, in the body of the method you need to create 3 heroes using
    the Hero class, using different constructor options (either the first or the second). Then place the created
    instances of heroes to an array and return it using the return command as the return result of the createHeroes method.
    Then call this method in the main method and print information about all the heroes of the array through the loop. */


        Hero[] heroes = createHeroes();
        for (Hero hero : heroes) {
            System.out.println("Hero Health: " + hero.getHealth() +
                    " Hero Damage: " + hero.getDamage()
                    + " Hero SuperPower: " + hero.getSuperpower());
        }
    }

    public static Hero[] createHeroes() {
        Hero physical = new Hero(250, 2);
        Hero medic = new Hero(450, 0, "Treatment from Medic");
        Hero berserk = new Hero(50, 5, "BossDamage blocking");
        Hero[] heroes = {physical, medic, berserk};
        return heroes;
    }

}



