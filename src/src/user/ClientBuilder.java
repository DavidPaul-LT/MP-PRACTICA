package src.user;

import src.app_utils.PlayerCharacter;
import src.battle.BattleRequest;
import src.battle.BattleResume;
import src.interfaces.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class ClientBuilder implements UserBuilder {
    private String name;
    private String nick;
    private String password;
    private String regNumber;
    private PlayerCharacter character = new PlayerCharacter();
    private int gold = 1000;
    private List<BattleResume> battleHistory = new ArrayList<>();
    private BattleRequest challenge;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public User build() throws InstantiationException {
        return new Client(this.name,this.nick,this.password,this.regNumber,this.character,this.gold, (ArrayList<BattleResume>) this.battleHistory,this.challenge);
    }

    public void setRegNumber(String regNumber){
        this.regNumber = regNumber;
    }

    public void setCharacter(PlayerCharacter character){
        this.character = character;
    }

    public void setGold(int gold){
        this.gold = gold;
    }

    public void setBattleHistory(List<BattleResume> battleHistory){
        this.battleHistory = battleHistory;
    }

    public void setChallenge(BattleRequest challenge){
        this.challenge = challenge;
    }

}
