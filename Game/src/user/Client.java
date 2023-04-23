package user;

import appUtils.PlayerCharacter;
import appUtils.Ranking;
import battle.*;
import equipment.*;
import storage.Storage;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public class Client extends User{
    private final String REG_NUMBER;
    private PlayerCharacter character;
    private int gold;
    private List<BattleResume> battleHistory;
    private BattleRequest challenge;

    public Client(String regNumber, String name, String nick, String password) {
        super(name, nick, password);
        this.REG_NUMBER = regNumber;
    }
    public Boolean requestable(){
        return this.challenge != null;
    }

    public void setActiveWeapon(Weapon w){
        character.setActiveWeapon(w);
    }
    public void setActiveArmor(Armor a){
        character.setActiveArmor(a);
    }

    /**
     * Creates a BattleRequest instance and stores it in storage general purpose HashMap.
     * @param challengedNick Client who is challenged by the user.
     * @param bet Part of user`s gold that would be bet if the Battle is performed.
     * @return True if process was performed successfully or false instead.
     */
    /*
    public Boolean sendBattleRequest(String challengedNick, int bet){
        Storage generalStorage = Storage.getInstance();
        Set<Serializable> clientExists = generalStorage.getValue("Client list");
        if (bet < this.gold && clientExists.contains(challengedNick)){ //Checks the gold amount and whether the challengedNick exists in storage. Missing not null challenge validation.
            BattleRequest newBattleProposal = new BattleRequest(this.getName(), challengedNick, bet);
            generalStorage.addToValue("Battle requests",newBattleProposal);
            return true;
        }
        return false;
    }
     */
    public void acceptBattleRequest(BattleRequest b){
        //Transform BattleRequest into Battle
    }
    public void refuseBattleRequest(BattleRequest b){
        Storage generalStorage = Storage.getInstance();
        //generalStorage.deleteFromValue("Challenges",this.challenge);
        this.challenge = null;
    }
    public Set<Client> checkGlobalRanking(){
        return null;//Ranking.getInstance().getRanking();
    }
}
