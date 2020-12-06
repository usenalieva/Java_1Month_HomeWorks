package com.makhabatusen.players;

public class Boss extends GameEntity{
    private boolean is_Stunned;

    public boolean is_Stunned() {
        return is_Stunned;
    }

    public void set_Stunned(boolean is_Stunned) {
        this.is_Stunned = is_Stunned;
    }

    public Boss(int health, int damage) {
        super(health, damage);
    }
}

