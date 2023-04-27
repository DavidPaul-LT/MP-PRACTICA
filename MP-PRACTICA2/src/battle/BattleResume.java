package battle;

import java.io.Serializable;
import java.util.Date;

public class BattleResume implements Serializable {
    private final String challenging;
    private final String challenged;
    private final Date combatDate;
    private final String winner;
    private final int minionsNotDefeated;
    private final int goldWon;
    public BattleResume(String challenging, String challenged, Date combatDate, String winner,int minionsNotDefeated,int goldWon){
        this.challenging = challenging;
        this.challenged = challenged;
        this.combatDate = combatDate;
        this.winner = winner;
        this.minionsNotDefeated = minionsNotDefeated;
        this.goldWon = goldWon;
    }

    public String getChallenging() {
        return challenging;
    }

    public String getChallenged() {
        return challenged;
    }

    public Date getCombatDate() {
        return combatDate;
    }

    public String getWinner() {
        return winner;
    }

    public int getMinionsNotDefeated() {
        return minionsNotDefeated;
    }

    public int getGoldWon() {
        return goldWon;
    }
}
