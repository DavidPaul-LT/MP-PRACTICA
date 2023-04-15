package user;

import appUtils.GeneralFactory;
import battle.BattleRequest;
import storage.Storage;

public class Operator extends User{
    private Storage storage;
    private GeneralFactory mainFactory;

    public Operator(String name, String nick, String password) {
        super(name, nick, password);
    }

    public void editEntity(String category, String name){}
    public void validateBattleRequest(BattleRequest b){}
    public void banUser(String nick){
        this.storage.getValue("Banned users").add(nick);
    }
    public void unbanUser(String nick){
        this.storage.getValue("Banned users").remove(nick); //Missing check if user not in banned list.
    }
}
