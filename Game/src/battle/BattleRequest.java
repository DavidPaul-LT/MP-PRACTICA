package battle;

import java.io.Serializable;

public class BattleRequest implements Serializable {
    private final String challenging;
    private final String challenged;
    private Boolean stateValid;
    private final int goldBet;
    public BattleRequest(String challenging, String challenged, int goldBet){
        this.challenging = challenging;
        this.challenged = challenged;
        this.goldBet = goldBet;
    }
    public void getInfoToBattleRequested(){}

    public String getChallenging() {
        return challenging;
    }

    public String getChallenged() {
        return challenged;
    }

    public int getGoldBet() {
        return goldBet;
    }
}
