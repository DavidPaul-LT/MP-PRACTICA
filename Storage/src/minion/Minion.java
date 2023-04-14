package minion;

import java.io.Serializable;

public class Minion implements Serializable {
    private final int MIN_HEALTH = 1;
    private final int MAX_HEALTH = 3;
    private String name;
    private int health;
    public Minion(String name){
        this.name = name;
        this.health = this.MAX_HEALTH;
    }
}
