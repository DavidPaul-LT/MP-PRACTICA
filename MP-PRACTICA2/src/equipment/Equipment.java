package equipment;

import java.io.Serializable;

public abstract class Equipment implements Serializable {
    private String name;
    private static final int MIN_MOD = 0;
    private static final int MAX_MOD = 3;
    private int attackMod;
    private int defenseMod;

    public int getAttackMod(){
        return this.attackMod;
    }
    public int getDefenseMod(){
        return this.defenseMod;
    }
}
