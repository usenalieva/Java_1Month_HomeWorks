package com.makhabatusen;

public class Boss {

    /* MAIN TASK:
    Create a class "Boss" with private fields health, damage and defense type.
    Add getters and setters for all fields to the class. */

    private String bossDefenceType;
    private int health;
    private int damage;


    public String getBossDefenceType() {
        return bossDefenceType;
    }

    public void setBossDefenceType(String bossDefenceType) {
        this.bossDefenceType = bossDefenceType;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public  void bossInfo() {
        System.out.println("Boss Health: " + health + " " + "Boss Damage: " +  damage + " "
                + "Boss Defence Type: " +  bossDefenceType);

    }
}
