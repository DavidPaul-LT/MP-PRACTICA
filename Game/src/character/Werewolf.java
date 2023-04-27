package character;

import equipment.Armor;
import equipment.Weapon;
import modifyer.Modifyer;
import skill.Gift;

import java.util.Set;

public class Werewolf extends Character{
    private final int MIN_RAGE = 0;
    private final int MAX_RAGE = 3;
    private int rage = MIN_RAGE;
    public int useAttackGift(Gift gift){
        int minRage = gift.getMinRageCost();
        if (rage >= minRage){
            return gift.getAttackValue();
        }
        else {
            return 0;
        }
    }

    public int useDefenseGift(Gift gift){
        int minRage = gift.getMinRageCost();
        if (rage >= minRage){
            return gift.getDefenseValue();
        }
        else {
            return 0;
        }
    }
    public int calculateAttackPotential(){
        int attackPotential = rage + getPower() + getActiveArmor().getAttackMod() + getActiveWeapon().getAttackMod() + getActiveWeapon2().getAttackMod() + useAttackGift((Gift) getSkill());
        for (Modifyer mod: getModifyers()){
            int modAtt = mod.getValue();
            attackPotential += modAtt;
        }
        return attackPotential;
    }
    public int calculateDefensePotential(){
        int defensePotential = rage + getPower() + getActiveArmor().getDefenseMod() + getActiveWeapon().getDefenseMod() + getActiveWeapon2().getDefenseMod() + useDefenseGift((Gift) getSkill());
        for (Modifyer mod: getModifyers()){
            int modDef = mod.getValue();
            defensePotential += modDef;
        }
        return defensePotential;
    }

    @Override
    public void damaged() {
        if (rage + 1 >= MAX_RAGE){
            this.rage++;
        }
    }

    @Override
    public void successAttack() {
    }

    @Override
    public int getAtribute() {
        return rage;
    }
}