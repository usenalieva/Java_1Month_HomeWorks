package com.makhabatusen;

public class Main {

    public static void main(String[] args) {

	/* Create a class Weapon with private fields for weapon type and weapon name.
    Create a GameEntity class (Game entity), select all common fields that are inherent in both the Boss and the Heroes
    and add getters and setters to them.
    Create a Boss class, inherit it from the GameEntity class and add a Weapon complex data type field to it
    (that is, give the weapon to the boss). Also add getters and setters for this field.
    In the Main class, create 1 instance of the boss and set all the properties (values for the fields) to it.
    Then print out all the information about the boss.*/


        new Boss (250,50, new Weapon("Rifle", "M 16")).info();;

    }
}
