package equipment;

import java.io.Serializable;

public abstract class Equipment implements Serializable {
    private String name;
    private static final int MIN_MOD = 0;
    private static final int MAX_MOD = 3;
    private int attackMod;

    public int getAttackMod(){
        return attackMod;
    }
    public int getDefenseMod(){
        return defenseMod;
    }
    private int defenseMod;
}
