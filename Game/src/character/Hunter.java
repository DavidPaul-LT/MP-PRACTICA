package character;

import equipment.Armor;
import equipment.Weapon;
import modifyer.Modifyer;
import skill.Talent;

import java.util.Set;

import java.util.List;

public class Hunter extends Character{
    private final int MIN_WILL = 0;
    private final int MAX_WILL = 3;
    private int willPower;
    public int calculateAttackPotential(){
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Talent talent = (Talent) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorAtt = armor.getAttackMod();
        int weaponAtt = weapon.getAttackMod();
        int talentAtt = talent.getAttackValue();
        int modsAtt = 0;
        for (Modifyer mod: modifyers){
            int modAtt = mod.getValue(); //No se si el metodo getValue de modificadores esta hecho
            modsAtt += modAtt;
        }
        return power + armorAtt + weaponAtt + willPower + modsAtt + talentAtt;
    }
    public int calculateDefensePotential(){
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Talent talent = (Talent) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorDef = armor.getDefenseMod();
        int weaponDef = weapon.getDefenseMod();
        int talentDef = talent.getDefenseValue();
        int modsDef = 0;
        for (Modifyer mod: modifyers){
            int modDef = mod.getValue(); //No se si el metodo getValue de modificadores esta hecho
            modsDef += modDef;
        }
        int DefPot = power + armorDef + weaponDef + willPower + modsDef + talentDef;
        return DefPot;
    }
}