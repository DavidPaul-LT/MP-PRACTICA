package character;

import equipment.Armor;
import equipment.Weapon;
import modifyer.Modifyer;
import skill.Discipline;
import skill.Gift;

import java.util.Set;

public class Werewolf extends Character{
    private final int MIN_RAGE = 0;
    private final int MAX_RAGE = 3;
    private int rage;
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
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Gift gift = (Gift) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorAtt = armor.getAttackMod();
        int weaponAtt = weapon.getAttackMod();
        int giftAtt = useAttackGift(gift);
        int modsAtt = 0;
        for (Modifyer mod: modifyers){
            int modAtt = mod.getValue(); //No se si el metodo getValue de modificadores esta hecho
            modsAtt += modAtt;
        }
        int attPot = power + armorAtt + weaponAtt + rage + modsAtt + giftAtt;
        return attPot;
    }
    public int calculateDefensePotential(){
        Armor armor = getActiveArmor();
        Weapon weapon = getActiveWeapon();
        Gift gift = (Gift) getSkill();
        Set<Modifyer> modifyers = getModifyers();
        int power = getPower();
        int armorDef = armor.getDefenseMod();
        int weaponDef = weapon.getDefenseMod();
        int giftDef = useDefenseGift(gift);
        int modsDef = 0;
        for (Modifyer mod: modifyers){
            int modDef = mod.getValue(); //No se si el metodo getValue de modificadores esta hecho
            modsDef += modDef;
        }
        int defPot = power + armorDef + weaponDef + rage + modsDef + giftDef;
        return defPot;
    }
}
