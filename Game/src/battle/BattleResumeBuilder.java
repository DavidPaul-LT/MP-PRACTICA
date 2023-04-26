package battle;

import interfaces.Factory;

import java.util.Date;

public class BattleResumeBuilder implements Factory {
    private String challenging;
    private String challenged;
    private Date combatDate;
    private String winner;
    private int minionsNotDefeated;
    private int goldWon;
    public void setChallenging(String challenging){
        this.challenging = challenging;
    }

    public void setChallenged(String challenged) {
        this.challenged = challenged;
    }

    public void setCombatDate(Date combatDate) {
        this.combatDate = combatDate;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void setMinionsNotDefeated(int minionsNotDefeated) {
        this.minionsNotDefeated = minionsNotDefeated;
    }

    public void setGoldWon(int goldWon) {
        this.goldWon = goldWon;
    }
    public BattleResume build(){
        return  new BattleResume(this.challenging,this.challenged,this.combatDate,this.winner,this.minionsNotDefeated,this.goldWon);
    }
}
