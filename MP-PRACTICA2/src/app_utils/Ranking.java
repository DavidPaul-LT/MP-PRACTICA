package app_utils;

import interfaces.Resetable;
import storage.Storage;

import java.io.Serializable;
import java.util.*;

public class Ranking implements Serializable, Resetable {
    private static final String RANKING_KEY = "Ranking";
    private static Ranking instance;
    private TreeMap<Integer, PriorityQueue<String>> rankingMap;
    private Map<String,Integer> invertedRanking;
    private Ranking(){
        this.rankingMap = new TreeMap<>();
        this.invertedRanking = new HashMap<>();
    }

    /**
     * Returns a Ranking instance.
     * @return Ranking
     */
    public static Ranking getInstance(){
        if (instance == null){
            instance = (Ranking) Storage.getInstance().getValue(RANKING_KEY);
            if(instance == null){
                instance = new Ranking();
            }
            return instance;
        }
        return instance;
    }

    public NavigableSet<Integer> getRankingValues(){
        return instance.rankingMap.navigableKeySet().descendingSet();
    }

    /**
     * Re-initializes the Ranking instance removing in the process all ranking's positions.
     */
    public static void reset(){
        instance = null;
    }
    public int getUserScore(String userNick){
        return this.invertedRanking.get(userNick);
    }
    public PriorityQueue<String> getScorePosition(int score){
        return this.rankingMap.get(score);
    }
    /**
     * Sets a user's score value and adds it to the ranking tree map.
     * @param userNick User's nickname
     * @param userScore User's score
     */
    public void setUserScore(String userNick, int userScore){
        if (this.invertedRanking.containsKey(userNick)){
            this.removeFromRanking(userNick);
        }
        this.invertedRanking.put(userNick,userScore);
        PriorityQueue<String> scoreLevel = this.rankingMap.get(userScore);
        if (scoreLevel != null){
            scoreLevel.add(userNick);
        }else{
            PriorityQueue<String> newQueue = new PriorityQueue<>();
            newQueue.add(userNick);
            this.rankingMap.put(userScore,newQueue);
        }
        Storage.getInstance().setValue(RANKING_KEY,instance);
    }

    /**
     * Removes a user from the ranking tree map.
     * @param userNick User's nickname
     */
    public void removeFromRanking(String userNick){
        int score = this.invertedRanking.get(userNick);
        PriorityQueue<String> scoreLevel = this.rankingMap.get(score);
        scoreLevel.remove(userNick);
        this.invertedRanking.remove(userNick);
        Storage.getInstance().setValue(RANKING_KEY,instance);
    }
}