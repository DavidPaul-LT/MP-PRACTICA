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
    public void setActiveArmor(Armor a){
        this.activeArmor = a;
    }
    public List<Minion> getMinions(){
        return minions;
    }
    public Set<Modifyer> getModifyers(){
        return modifyers;
    }
    public int getHealth(){
        return health;
    }
    public Armor getActiveArmor(){
        return activeArmor;
    }
    public Weapon getActiveWeapon(){
        return activeWeapon;
    }
    public int getPower(){
        return power;
    }
    public Skill getSkill(){
        return specialAbility;
    }
    public abstract int calculateAttackPotential();
    public abstract int calculateDefensePotential();
}
