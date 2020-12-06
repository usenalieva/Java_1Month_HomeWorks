package com.makhabatusen.game;

import com.makhabatusen.players.*;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(1100, 50);

        Warrior warrior = new Warrior(260, 20);
        Medic doctor = new Medic(220, 0, 20, "Doctor");
        Magic magic = new Magic(240, 15);
        Medic youngMedic = new Medic(280, 0, 10, "Young Medic");
        Golem golem = new Golem(250, 10);
        Thor thor = new Thor(220, 10);
        Tank tank = new Tank(500, 5);
        Witcher witcher = new Witcher(250, 0);
        TrickyBastard bastard = new TrickyBastard(280, 30);


        Hero[] heroes = {warrior, doctor, magic, youngMedic, golem, thor, tank, witcher, bastard};

        int roundNumber = 0;


        printStatistics(boss, heroes, doctor, youngMedic);
        while (!isGameFinished(boss, heroes)) {
            roundNumber++;
            System.out.println("ROUND: " + roundNumber);
            round(boss, heroes, doctor, youngMedic);
        }
    }


    private static void round(Boss boss, Hero[] heroes, Medic doctor, Medic youngMedic) {
        applySuperAbilitiesBefore(boss, heroes);
        if (boss.getHealth() > 0 && !boss.is_Stunned()) {
            bossHits(boss, heroes);
        } else {
            System.out.println("Boss skips the round");
        }
        heroesHit(boss, heroes);
        applySuperAbilitiesAfter(boss, heroes);

        printStatistics(boss, heroes, doctor, youngMedic);

    }


    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes, Medic doctor, Medic youngMedic) {
        System.out.println("_______________");
        System.out.println("Boss health: " + boss.getHealth());
        for (Hero hero : heroes) {
            if (hero.equals(heroes[1])) {
                System.out.println(doctor.getName() + " health: " + doctor.getHealth());
            }
            if (hero.equals(heroes[3])) {
                System.out.println(youngMedic.getName() + " health: " + youngMedic.getHealth());

            } else {
                System.out.println(hero.getClass().getSimpleName()
                        + " health: " + hero.getHealth());
            }
        }
        System.out.println("_______________");
    }


    private static void bossHits(Boss boss, Hero[] heroes) {

        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
        System.out.println("Boss attacks");
    }


    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }

    private static void applySuperAbilitiesBefore(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 ||
                    (hero instanceof TrickyBastard &&
                            ((TrickyBastard) hero).getLastHealth() != 0)) {
                hero.applySuperAbilityBeforeRound(boss, heroes);
            }
        }
    }

    private static void applySuperAbilitiesAfter(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.applySuperAbilityAfterRound(boss, heroes);
            }
        }
    }
}


