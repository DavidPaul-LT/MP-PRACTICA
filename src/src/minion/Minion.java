package src.minion;

import java.io.Serializable;

public abstract class Minion implements Serializable {
    private final int MIN_HEALTH = 1;
    private final int MAX_HEALTH = 3;
    private String name;
    private int health;
    public Minion(String name){
        this.name = name;
        this.health = this.MAX_HEALTH;
    }

    public int getHealth() {
        return this.health;
    }
}
