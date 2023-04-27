package app_utils;

import equipment.Armor;
import equipment.Weapon;
import character.Character;

import java.io.Serializable;

public class PlayerCharacter implements Serializable {
    private Character character;
    public void setActiveWeapon(Weapon w){
        character.setActiveWeapon(w);
    }
    public void setActiveArmor(Armor a){
        character.setActiveArmor(a);
    }
    public Character getCharacter(){
        return this.character;
    }
    public void setCharacter(Character newCharacter) {
        this.character = newCharacter;
    }
}
