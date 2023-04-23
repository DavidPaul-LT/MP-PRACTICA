package user;

import appUtils.PlayerCharacter;
import appUtils.Ranking;
import battle.*;
import equipment.Armor;
import equipment.Weapon;
import storage.Storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;


public class Client extends User{
    private final String regNumber;
    private PlayerCharacter character;
    private final int gold;
    private List<BattleResume> battleHistory;
    private final BattleRequest challenge;

    public Client(String name, String nick, String password, String regNumber, PlayerCharacter character, int gold, List<BattleResume> battleHistory, BattleRequest challenge) throws InstantiationException {
        super(name, nick, password);
        this.regNumber = regNumber;
        this.character = character;
        this.gold = gold;
        this.battleHistory = battleHistory;
        this.challenge = challenge;
    }
    public Boolean isRequestable(){
        return this.challenge == null;
    }
    public void setActiveWeapon(Weapon w){
        this.character.setActiveWeapon(w);
    }
    public void setActiveArmor(Armor a){
        this.character.setActiveArmor(a);
    }
    public Boolean sendBattleRequest(String challenged, int bet){
        Storage storageAccess = Storage.getInstance();
        HashMap<String,HashMap<String, Serializable>> usersInStorageValue= (HashMap<String, HashMap<String, Serializable>>) storageAccess.getValue("Users");
        Client challengedUser = (Client) usersInStorageValue.get("Clients").get(challenged);
        if (challengedUser != null && challengedUser.isRequestable() && challengedUser.getGold() >= bet){
            BattleRequest newChallenge = new BattleRequest(this.nick,challenged,bet);
            HashMap<String,BattleRequest> requests = (HashMap<String, BattleRequest>) storageAccess.getValue("Battle requests");
            if (requests == null){
                requests = new HashMap<>();
            }
            requests.put("Battle requests",newChallenge);
            return true;
        }
        return false;
    }

    public void acceptBattleRequest(){
        // TODO document why this method is empty
    }
    public void refuseBattleRequest(){
        // TODO Pay to challenger and delete the BattleRequest.
    }
    public Ranking checkGlobalRanking(){
        return Ranking.getInstance();
    }
    public String getRegNumber() {
        return regNumber;
    }
    public PlayerCharacter getCharacter(){
        return character;
    }
    public int getGold() {
        return gold;
    }
    public List<BattleResume> getBattleHistory() {
        return battleHistory;
    }
    public BattleRequest getChallenge(){
        return challenge;
    }
}
