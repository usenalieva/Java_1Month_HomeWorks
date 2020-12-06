package com.makhabatusen;

public class Main {

    public static void main(String[] args) {

    /*  MAIN TASK:
    Create a return method that will take 2 input parameters - the person's age and temperature
    on the street, and return the result as a string. The algorithm of the method should work as follows:
    ○ if the person's age is from 20 to 45 years old and the temperature outside is from -20 to 30
    degrees, the returned result is “You can go for a walk”;
    ○ if the person is under 20 years old and the temperature outside is in the range from 0
    up to 28 degrees, then the result is again - “You can go for a walk”;
    ○ and if a person is over 45 years old, then the result “You can go for a walk” is formed
    only when the outside temperature is in the range from -10 to 25 degrees;
    ○ In other cases, the method should return the result - “Please, stay home.”;
    ● In the main method, call the written method 5 times with different input data (arguments)
    and print the result to the console. */

        System.out.println(walk(25, 29));
        System.out.println(walk(30, 38));
        System.out.println(walk(19, 15));
        System.out.println(walk(13, 40));
        System.out.println(walk(46, -25));


        System.out.println(walkWithRandomAge(23));
        System.out.println(walkWithRandomAge(35));

    }

    public static String walk(int age, int temp) {

        String canGo = "Age: " + age + " " + "Temperature: " + temp + " You can go for a walk.";
        String stayHome = "Age: " + age + " " + "Temperature: " + temp + " Please, stay home.";

        if ((age > 20 && age < 45) && (temp > -20 && temp < 30)) {
            return canGo;

        } else if (age < 20 && temp > 0 && temp < 28) {
            return canGo;

        } else if (age > 45 && temp > -10 && temp < 25) {
            return canGo;

        } else {
            return stayHome;
        }

    }

    /* ADDITIONAL TASK:
    ● Write a method in which a random age is generated public static int generateRandomAge () {........}
    ● When calling a method that generates the result "can I go for a walk" use the generation
    a random age using the “generateRandomAge” method. */

    public static int generateRandomAge() {
        return (int) (Math.random() * 95);
    }

    public static String walkWithRandomAge(int temp) {

        int randomAge = generateRandomAge();

        String canGo = "Age: " + randomAge + " " + "Temperature: " + temp + " You can go for a walk.";
        String stayHome = "Age: " + randomAge + " " + "Temperature: " + temp + " Please, stay home.";

        if ((randomAge > 20 && randomAge < 45) && (temp > -20 && temp < 30)) {
            return canGo;

        } else if (randomAge < 20 && temp > 0 && temp < 28) {
            return canGo;

        } else if (randomAge > 45 && temp > -10 && temp < 25) {
            return canGo;

        } else {
            return stayHome;
        }
    }
}



