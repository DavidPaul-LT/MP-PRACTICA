package user;

import battle.BattleRequest;
import storage.Storage;

public class Operator extends User{
    private Storage storage;
    public void editEntity(String category, String name){}
    public void validateBattleRequest(BattleRequest b){}
    public void banUser(String nick){}
    public void debanUser(String nick){}
}
