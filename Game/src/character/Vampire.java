package character;

import equipment.Armor;
import equipment.Weapon;
import modifyer.Modifyer;
import skill.Discipline;

import java.util.Set;

public class Vampire extends Character{
    private final int MIN_BLOOD = 0;
    private final int MAX_BLOOD = 10;
    private int bloodPoints;
    private int age;
    public int getAditionalPotential(){
        if(bloodPoints >= 5){
            return 2;
        }
        else {
            return 0;
        }
    }
    public int useAttackDiscipline(Discipline discipline){
        int bloodCost = discipline.getBloodCost();
        if (bloodPoints >= bloodCost){
            bloodPoints -= bloodCost;
            return discipline.getAttackValue();
        }
        else {
            return 0;
        }
    }
    //Falta hacer que en el combate, si el ataque del vampiro tiene exito, se le sumen 4 puntos de sangre
    public int useDefenseDiscipline(Discipline discipline){
        int bloodCost = discipline.getBloodCost();
        if (bloodPoints >= bloodCost){
            bloodPoints -= bloodCost;
            return discipline.getDefenseValue();
        }
        else {
            return 0;
        }
    }

    public int calculateAttackPotential(){
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Discipline discipline = (Discipline) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorAtt = armor.getAttackMod();
        int weaponAtt = weapon.getAttackMod();
        int disciplineAtt = useAttackDiscipline(discipline);
        int modsAtt = 0;
        for (Modifyer mod: modifyers){
            int modAtt = mod.getValue();
            modsAtt += modAtt;
        }
        return power + armorAtt + weaponAtt + getAditionalPotential() + modsAtt + disciplineAtt;
    }
    public int calculateDefensePotential(){
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Discipline discipline = (Discipline) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorDef = armor.getDefenseMod();
        int weaponDef = weapon.getDefenseMod();
        int disciplineDef = useDefenseDiscipline(discipline);
        int modsDef = 0;
        for (Modifyer mod: modifyers){
            int modDef = mod.getValue();
            modsDef += modDef;
        }
        return power + armorDef + weaponDef + getAditionalPotential() + modsDef + disciplineDef;
    }
}