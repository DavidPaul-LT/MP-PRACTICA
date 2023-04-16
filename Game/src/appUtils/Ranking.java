package appUtils;

import storage.Storage;
import user.Client;

import java.io.Serializable;
import java.util.Set;
import java.util.TreeSet;

public class Ranking implements Serializable {
    private static Ranking instance;
    private Set<Client> ranking;
    private Ranking(){
        this.ranking = new TreeSet<>();
    }
    public static Ranking getInstance(){
        if (instance == null){
            instance = new Ranking();
        }
        return instance;
    }
    public Set<Client> getRanking() {
        return ranking;
    }
    public void addToRanking(){}
    public void removeFromRanking(){}
    public void updateInRanking(){}
}
