package character;


import modifyer.Modifyer;
import skill.Talent;


public class Hunter extends Character{
    private static final int MIN_WILL = 0;
    private static final int MAX_WILL = 3;
    private int willPower;
    public int calculateAttackPotential(){
        int attackPotential = willPower + getPower() + getActiveArmor().getAttackMod() + getActiveWeapon().getAttackMod() + ((Talent) getSkill()).getAttackValue();
        for (Modifyer mod: getModifyers()){
            int modAtt = mod.getValue();
            attackPotential += modAtt;
        }
        return attackPotential;
    }
    public int calculateDefensePotential(){
        int defensePotential = willPower + getPower() + getActiveArmor().getDefenseMod() + getActiveWeapon().getDefenseMod() + ((Talent) getSkill()).getDefenseValue();
        for (Modifyer mod: getModifyers()){
            int modDef = mod.getValue();
            defensePotential += modDef;
        }
        return defensePotential;
    }
}