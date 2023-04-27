package character;

import equipment.Armor;
import equipment.Weapon;
import modifyer.Modifyer;
import skill.Discipline;

import java.util.Set;

public class Vampire extends Character{
    private final int MIN_BLOOD = 0;
    private final int MAX_BLOOD = 10;
    private int bloodPoints = MIN_BLOOD;
    private int age;
    public int getAditionalPotential(){
        if(bloodPoints >= 5){
            return 2;
        }else {
            return 0;
        }
    }
    public int useAttackDiscipline(Discipline discipline){
        int bloodCost = discipline.getBloodCost();
        if (bloodPoints >= bloodCost){
            bloodPoints -= bloodCost;
            return discipline.getAttackValue();
        }
        return 0;
    }
    //Falta hacer que en el combate, si el ataque del vampiro tiene exito, se le sumen 4 puntos de sangre
    public int useDefenseDiscipline(Discipline discipline){
        int bloodCost = discipline.getBloodCost();
        if (bloodPoints >= bloodCost){
            bloodPoints -= bloodCost;
            return discipline.getDefenseValue();
        }
        return 0;
    }

    public int calculateAttackPotential(){
        int attackPotential = getPower() + getActiveArmor().getAttackMod() + getActiveWeapon().getAttackMod() + getActiveWeapon2().getAttackMod() + useAttackDiscipline((Discipline) getSkill());
        for (Modifyer mod: getModifyers()){
            int modAtt = mod.getValue();
            attackPotential += modAtt;
        }
        return getAditionalPotential() + attackPotential;
    }
    public int calculateDefensePotential() {
        int defensePotential = getPower() + getActiveArmor().getDefenseMod() + getActiveWeapon().getDefenseMod() + getActiveWeapon2().getDefenseMod() + useDefenseDiscipline((Discipline) getSkill());
        for (Modifyer mod : getModifyers()) {
            int modDef = mod.getValue();
            defensePotential += modDef;
        }
        return getAditionalPotential() + defensePotential;
    }

    @Override
    public void damaged() {
    }

    @Override
    public void successAttack() {
        if (bloodPoints + 4 <= MAX_BLOOD){
            bloodPoints += 4;
        }
        else{
            bloodPoints = MAX_BLOOD;
        }
    }

    @Override
    public int getAtribute() {
        return bloodPoints;
    }
}