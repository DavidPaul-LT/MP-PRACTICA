package src.skill;

import java.io.Serializable;

public class Skill implements Serializable {
    private String name;
    private final int MIN_VALUE = 1;
    private final int MAX_VALUE = 3;
    private int attackValue;
    private int defenseValue;

    public int getAttackValue() {
        return attackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }
}
