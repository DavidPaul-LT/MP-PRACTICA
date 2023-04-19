package appUtils;

public class RankingTuple implements Comparable<RankingTuple>{
    private final int battlesWon;
    private final String user;
    public RankingTuple(int battlesWon, String user){
        this.battlesWon = battlesWon;
        this.user = user;
    }
    @Override
    public int compareTo(RankingTuple other) {
        int battleCompare = Integer.compare(other.getBattlesWon(),this.battlesWon);
        if (battleCompare == 0){
            return this.user.compareTo(other.getUser());
        }
        return battleCompare;
    }

    public int getBattlesWon() {
        return battlesWon;
    }
    
    public String getUser() {
        return user;
    }
}
