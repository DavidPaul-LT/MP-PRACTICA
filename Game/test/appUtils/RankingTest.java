package appUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void initializationTest(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        assertEquals(testRanking,Ranking.getInstance());
    }
    @Test
    void userInsertionTest(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        String testUser = "Paul";
        int testScore = 50;
        testRanking.setUserScore(testUser,testScore);
        assertEquals(testScore,testRanking.getUserScore(testUser));
    }
    @Test
    void userScoreUpdate(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        String testUser = "Paul";
        int testScore = 50;
        testRanking.setUserScore(testUser,testScore);
        testRanking.setUserScore(testUser,testScore*2);
        assertEquals(testScore*2,testRanking.getUserScore(testUser));
    }
    @Test
    void multipleScorePositionsTest(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        String[] userNames = {"Peter", "Charles", "Paul"};
        int testScore = 150;
        for (String userNick: userNames) {
            testRanking.setUserScore(userNick,testScore);
        }
        assertEquals(userNames.length,testRanking.getScorePosition(testScore).size());
    }
    @Test
    void userDeletionTest(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        testRanking.setUserScore("Peter",12);
        testRanking.removeFromRanking("Peter");
        assertTrue(testRanking.getScorePosition(12).isEmpty());
    }
}