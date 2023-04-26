package battle;

import java.io.Serializable;
import user.Client;

public class BattleResume implements Serializable {
    private Client challengingUser;
    private Client challengedUser;
    private int roundNumber;
    private String date;
    private Client winner;
    private int goldWon;
    private String userWithMinionsAlive;
    public void updateBattleResume(){}
}
