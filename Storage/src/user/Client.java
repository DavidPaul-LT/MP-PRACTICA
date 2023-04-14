package user;

import appUtils.PlayerCharacter;
import battle.BattleRequest;
import battle.BattleResume;
import equipment.Armor;
import equipment.Weapon;

import java.util.List;

public class Client extends User{
    private final String REG_NUMBER;
    private PlayerCharacter character;
    private int gold;
    private List<BattleResume> history;
    private BattleRequest challenge;

    public Client(String regNumber) {
        REG_NUMBER = regNumber;
    }

    public void setActiveWeapon(Weapon w){

    }
    public void setActiveArmor(Armor a){

    }
    public void sendBattleRequest(Client challenged, int bet){

    }
    public void acceptBattleRequest(BattleRequest b){

    }
    public void refuseBattleRequest(BattleRequest b){

    }
    public void checkGlobalRanking(){}
}
