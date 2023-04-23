package user;

import appUtils.GeneralFactory;
import battle.BattleRequest;
import storage.Storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Operator extends User{
    private Storage storage;
    private GeneralFactory mainFactory;

    public Operator(String name, String nick, String password, GeneralFactory mainFactory) throws InstantiationException {
        super(name, nick, password);
        storage = Storage.getInstance();
        this.mainFactory = mainFactory;
    }

    public void editEntity(String category, String name){}
    public void validateBattleRequest(BattleRequest b){}
    public void banUser(String nick){
        HashMap<String, HashMap<String, Serializable>> usersInStorageValue = (HashMap<String, HashMap<String, Serializable>>) storage.getValue("Users");
        Client user = (Client) usersInStorageValue.get("Clients").get(nick);
        Set<String> bannedList = (Set<String>) storage.getValue("Banned clients");
        if (user != null){
            if (bannedList != null){
                bannedList.add(nick);
            }else{
                bannedList = new HashSet<>();
                bannedList.add(nick);
            }
        }
    }
    public void unbanUser(String nick){
        Set<String> bannedList = (Set<String>) storage.getValue("Banned clients");
        bannedList.remove(nick);
    }
}
