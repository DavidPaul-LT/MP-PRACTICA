package appUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import storage.Storage;

class RankingTest {
    @Test
    void uniqueInstanceTest(){
        Ranking testRanking = Ranking.getInstance();
        assertEquals(testRanking,Ranking.getInstance());
    }
    @Test
    void notNullQueue(){
        Ranking testRanking = Ranking.getInstance();
        int testScore = (int) (Math.random()*100);
        String testUser = "RandomUser";
        testRanking.addUser(testUser,testScore);
        assertNotNull(testRanking.getScore(testScore));
    }
    @Test
    void addUserTest(){
        Ranking testRanking = Ranking.getInstance();
        int testScore = (int) (Math.random()*100);
        String testUser = "RandomUser";
        testRanking.addUser(testUser,testScore);

        Ranking testRanking2 = Ranking.getInstance();
        assertTrue(testRanking2.getScore(testScore).contains(testUser));
    }
    @Test
    void userRemovalTest(){
        Ranking testRanking = Ranking.getInstance();
        String testUser = "RandomUser";
        int testScore = 15;
        String testUser2 = "OtherRandomUser";
        testRanking.addUser(testUser,testScore);
        testRanking.addUser(testUser2,testScore);
        testRanking.removeUser(testUser);
        assertEquals(1,Ranking.getInstance().getScore(testScore).size());
    }
    @Test
    void updateUserScoreTest(){
        Ranking testRanking = Ranking.getInstance();
        String testUser = "RandomUser";
        int testScore = 15;
        testRanking.addUser(testUser,testScore);
        testRanking.updateUserScore(testUser,testScore+15);
        assertNotNull(testRanking.getScore(testScore+15));
        assertNotNull(testRanking.getScore(15));
    }
}