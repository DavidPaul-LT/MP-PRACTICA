package appUtils;

import equipment.Armor;
import equipment.Weapon;
import character.Character;

public class PlayerCharacter {
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
