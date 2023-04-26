package character;

import equipment.Armor;
import equipment.Weapon;
import interfaces.Master;
import minion.Minion;
import modifyer.Modifyer;
import skill.Skill;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public abstract class Character implements Master, Serializable {
    private String name;
    private Skill specialAbility;
    private Set<Weapon> weapons;
    private Weapon activeWeapon;
    private Set<Armor> armors;
    private Armor activeArmor;
    private List<Minion> minions;
    private final int MIN_HEALTH = 0;
    private final int MAX_HEALTH = 5;
    private int health;
    private final int MIN_POWER = 0;
    private final int MAX_POWER = 3;
    private int power;
    private Set<Modifyer> modifyers;
    public void setActiveWeapon(Weapon w){
        this.activeWeapon = w;
    }
    public Weapon getActiveWeapon(){
        return this.activeWeapon;
    }
    public void setActiveArmor(Armor a){
        this.activeArmor = a;
    }
    public Armor getActiveArmor(){
        return this.activeArmor;
    }

    public int getHealth() {
        return this.health;
    }
    public Skill getSkill(){
        return this.specialAbility;
    }


    public List<Minion> getMinions() {
        return this.minions;
    }

    public abstract int calculateAttackPotential();

    public abstract int calculateDefensePotential();

    public String getName() {
        return name;
    }

    public Set<Weapon> getWeapons() {
        return weapons;
    }

    public Set<Armor> getArmors() {
        return armors;
    }

    public int getMIN_HEALTH() {
        return MIN_HEALTH;
    }

    public int getMAX_HEALTH() {
        return MAX_HEALTH;
    }

    public int getMIN_POWER() {
        return MIN_POWER;
    }

    public int getMAX_POWER() {
        return MAX_POWER;
    }

    public Set<Modifyer> getModifyers() {
        return modifyers;
    }

    public int getPower() {
        return power;
    }
}
