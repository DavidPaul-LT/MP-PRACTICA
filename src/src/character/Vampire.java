package src.character;

import src.modifyer.Modifyer;
import src.skill.Discipline;

public class Vampire extends Character{
    private final int MIN_BLOOD = 0;
    private final int MAX_BLOOD = 10;
    private int bloodPoints;
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
        int attackPotential = getPower() + getActiveArmor().getAttackMod() + getActiveWeapon().getAttackMod() + useAttackDiscipline((Discipline) getSkill());
        for (Modifyer mod: getModifyers()){
            int modAtt = mod.getValue();
            attackPotential += modAtt;
        }
        return getAditionalPotential() + attackPotential;
    }
    public int calculateDefensePotential(){
        int defensePotential = getPower() + getActiveArmor().getDefenseMod() + getActiveWeapon().getDefenseMod() + useDefenseDiscipline((Discipline) getSkill());
        for (Modifyer mod: getModifyers()){
            int modDef = mod.getValue();
            defensePotential += modDef;
        }
        return defensePotential + getAditionalPotential();
    }
}