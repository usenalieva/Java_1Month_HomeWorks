package com.makhabatusen;

import java.util.Random;

public class Main {

    // First RPG

    public static int bossHealth = 700;
    public static int bossDamage = 50;
    public static String bossDefenceType = "";
    public static int[] heroesHealth = {150, 160, 170, 150, 200, 100, 50, 100};
    public static int[] heroesDamage = {20, 15, 25, 0, 10, 10, 5, 15};
    public static String[] heroesAttackType = {"Physical",
            "Magical", "Kinetic", "Medic", "Golem", "Lucky", "Berserk", "Thor"};
    public static int roundNumber = 0;


    // I've creative a formula here just to make my Life easier )

    public static int fourFifthOfBossDamage = bossDamage * 4 / 5;
    public static int oneFifthOfBossDamage = bossDamage / 5;


    public static void main(String[] args) {
        System.out.println("Game starts");
        printStatistics();
        while (!isGameFinished()) {
            roundNumber++;
            System.out.println("Round: " + roundNumber);
            round();
        }
    }


    // Medic is not on the list of changeBossDefence

    public static void changeBossDefence() {
        Random r = new Random();
        int randomIndex = r.nextInt(heroesAttackType.length);

        for (int i = 0; i < heroesAttackType.length; i++) {

            if (!heroesAttackType[randomIndex].equals(heroesAttackType[3])) {
                bossDefenceType = heroesAttackType[randomIndex];
                System.out.println("Boss choose " + bossDefenceType);
                System.out.println("___");
                break;
            }
        }
    }


    public static void round() {
        changeBossDefence();
        heroesHit();
        if (incomparableThor())
            System.out.println("Boss was blocked by Thor for this round");
         else {
            if (bossHealth > 0) {
                bossHits();
                if (heroesHealth[4] > 0) {
                    poorGolem();
                }
                if (heroesHealth[5] > 0) {
                    luckyLucky();
                }
                if (heroesHealth[6] > 0) {
                    almightyBerserk();
                    if (bossHealth < 0) {
                        bossHealth = 0;
                    }
                }
            }

        }
        if (heroesHealth[3] >= 50) {
            treatmentFromMedic();
        }
        printStatistics();
    }

    public static boolean isGameFinished() {
        if (bossHealth <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int health : heroesHealth) {
            if (health > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }


    public static void bossHits() {
        for (int i = 0; i < heroesHealth.length; i++) {
            if (heroesHealth[i] > 0) {
                if (heroesHealth[i] < bossDamage) {
                    heroesHealth[i] = 0;
                } else {
                    heroesHealth[i] = heroesHealth[i] - bossDamage;
                }
            }
        }
        System.out.println("___");
        System.out.println("Boss's attack: " + bossDamage * heroesHealth.length);
    }


    public static void heroesHit() {
        for (int i = 0; i < heroesDamage.length; i++) {
            if (heroesHealth[i] > 0) {
                if (bossHealth > 0) {
                    if (bossDefenceType.equals(heroesAttackType[i])) {
                        Random r = new Random();
                        int randNum = r.nextInt(8) + 2; //2,3,4,5,6,7,8,9
                        if ((bossHealth - heroesDamage[i] * randNum) < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i] * randNum;
                        }
                        System.out.println(("Critical attack from " + heroesAttackType[i] + " " + heroesDamage[i] +
                                "*" + randNum) + " = " + (heroesDamage[i] * randNum));

                    } else {
                        if (bossHealth - heroesDamage[i] < 0) {
                            bossHealth = 0;
                        } else {
                            bossHealth = bossHealth - heroesDamage[i];

                        }
                        System.out.println(heroesAttackType[i] + " attacks: " + +heroesDamage[i]);
                    }
                } else {
                    break;
                }
            }
        }
    }


    public static void printStatistics() {
        System.out.println("__________________");
        System.out.println("Boss health: " + bossHealth);
        for (int i = 0; i < heroesAttackType.length; i++) {
            System.out.println(heroesAttackType[i]
                    + " Health: " + heroesHealth[i]);
        }
        System.out.println("__________________");
    }

    /* MAIN TASK:
    Add the 4th player Medic who has the ability to heal after each round for a N amount
   health units of only one of the team members with health less than 100 units. Dead heroes medic
   cannot revive, and he heals as long as he is alive. Medic does not participate in combat,
   but takes damage from the Boss*/

    // When Medic treats he gives Health from his own Health

    public static void treatmentFromMedic() {

        for (int i = 0; i < heroesHealth.length; i++) {

            int treatmentAmount = 50;

            int randomLuck = (int) (Math.random() * heroesHealth.length);

            if (heroesHealth[randomLuck] != heroesHealth[3] && heroesHealth[randomLuck] > 0 && heroesHealth[randomLuck] < 100) {
                heroesHealth[randomLuck] += treatmentAmount;

                heroesHealth[3] -= treatmentAmount;
                System.out.println("___");
                System.out.println(heroesAttackType[randomLuck] + " gets treatment from Medic + " + treatmentAmount);
                break;
            }
        }
    }

    /*  ADDITIONAL TASK:
    1) Add the nth player Golem, has an increased life but a weak hit. Can take 1/5 part
    damage from boss to other players. */

    /* Method bossHits runs first as usual,
    then  poorGolem comes and takes 1/5 of bossDamage from other players.
    Thus, bossDamage to Golem will be 120 (while there're 8 players in the game), and  40 to others */


    public static void poorGolem() {

        int returned = 0;

        for (int i = 0; i < heroesHealth.length; i++) {
            if (!heroesAttackType[i].equals("Golem")) {
                heroesHealth[i] = heroesHealth[i] + oneFifthOfBossDamage;
                returned += oneFifthOfBossDamage;
            }
        }
        if (heroesHealth[4] > returned) {
            heroesHealth[4] -= returned;
            System.out.println("___");
            System.out.println("Poor Golem takes over 1/5 of bossHits towards other players");
        } else
            System.out.println("Poor Golem cannot help others");

    }



    // 2) Add the nth player Lucky, has a chance to dodge boss hits.

    /* If Lucky gets lucky, he will get back his Health from bossDamage (which is 40),
    and Golem will get back his 1/5 of bossDamage too (which is 10)  */

    public static void luckyLucky() {
        Random l = new Random();
        int luckyLuck = l.nextInt(heroesAttackType.length);
        if (heroesAttackType[luckyLuck].equals(heroesAttackType[5])) {
            heroesHealth[5] = heroesHealth[5] + fourFifthOfBossDamage;
            heroesHealth[4] = heroesHealth[4] + oneFifthOfBossDamage;
            System.out.println("___");
            System.out.println("Lucky dodges from bossAttack");
            System.out.println("Golem gets his 1/5 of BossDamage back");


        } else {
            System.out.println("___");
            System.out.println("Lucky wasn't lucky in this round");
            System.out.println("It was: " + heroesAttackType[luckyLuck] + ". But he's not Lucky, so nothing wont happen ))) ");

        }
    }

    /* 3) Add the nth player Berserk, he blocks part of the boss hit on himself and adds the blocked damage to his
    damage and returns it to the boss */

    // Berserk will receive bossDamage only partly (for random % of bossDamage)!

    public static void almightyBerserk() {
        int percent = (int) (Math.random() * 100);
        int damageFromBoss = (fourFifthOfBossDamage * percent / 100);
        int damageFromBerserk = fourFifthOfBossDamage + (fourFifthOfBossDamage * percent / 100);
        heroesHealth[6] = heroesHealth[6] + damageFromBoss;
        bossHealth = bossHealth - damageFromBerserk;


        System.out.println("___");
        System.out.println("Berserk blocking bossDamage towards him for amount: " + damageFromBoss);
        System.out.println("Attacking back with bossDamage + bossDamage * " +
                +percent + " % = " + damageFromBerserk);

    }

    /* 4) Add the n-th player Thor, has a chance to stun the boss for 1 round, as a result of which the boss misses
    1 round and does not damage heroes. */

    public static boolean incomparableThor() {
        Random r = new Random();
        int attack = r.nextInt(heroesAttackType.length);
        return heroesAttackType[attack].equals(heroesAttackType[7]);
    }

}

