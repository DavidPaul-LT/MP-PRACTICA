package user;

import appUtils.PlayerCharacter;
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
    private int gold;
    private List<BattleResume> battleHistory;
    private BattleRequest challenge;

    public Client(String regNumber, String name, String nick, String password) throws InstantiationException {
        super(name, nick, password);
        this.regNumber = regNumber;
    }
    public Boolean isRequestable(){
        return this.challenge != null;
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
        if (challengedUser != null && challengedUser.isRequestable()){
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

    public String getRegNumber() {
        return regNumber;
    }
}
