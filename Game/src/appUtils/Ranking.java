package appUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Ranking implements Serializable {
    private static Ranking instance;
    private TreeMap<Integer, PriorityQueue<String>> ranking;
    private Map<String,Integer> invertedRanking;
    private Ranking(){
        this.ranking = new TreeMap<>();
        this.invertedRanking = new HashMap<>();
    }
    public static Ranking getInstance(){
        if (instance == null){
            instance = new Ranking();
            return instance;
        }
        return instance;
    }
    public PriorityQueue<String> getScore(int score){
        return this.ranking.get(score);
    }
    public void addUser(String userNick, int score){
        PriorityQueue<String> scorePosition = this.getScore(score);
        if (scorePosition == null){
            scorePosition = new PriorityQueue<>();
        }
        this.invertedRanking.put(userNick,score);
        scorePosition.add(userNick);
        this.ranking.put(score,scorePosition);
    }
    public void removeUser(String userNick){
        Integer userScore = this.invertedRanking.get(userNick);
        if (userScore != null){
            PriorityQueue<String> scorePosition = this.getScore(userScore);
            scorePosition.remove(userNick);
            //this.ranking.put(userScore,scorePosition);
            this.invertedRanking.remove(userNick);
        }
    }
    public void updateUserScore(String userNick, int newScore){
        Integer userScore = this.invertedRanking.get(userNick);
        if (userScore != null){
            this.removeUser(userNick);
            this.addUser(userNick,userScore);
        }
    }
    public static void reset(){
        instance = null;
    }

}
