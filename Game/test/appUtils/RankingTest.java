package appUtils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RankingTest {
    @Test
    void uniqueInstanceTest(){
        Ranking testRanking = Ranking.getInstance();
        Ranking testRanking2 = Ranking.getInstance();
        assertEquals(testRanking,testRanking2);
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
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        int testScore = (int) (Math.random()*100);
        String testUser = "RandomUser";
        testRanking.addUser(testUser,testScore);
        Ranking testRanking2 = Ranking.getInstance();
        assertTrue(testRanking2.getScore(testScore).contains(testUser));
    }
    @Test
    void userRemovalTest(){
        Ranking.reset();
        Ranking test2Ranking = Ranking.getInstance();
        String testUser = "RandomUser";
        int testScore = 15;
        String testUser2 = "OtherRandomUser";
        String testUser3 = "AnyOtherPerson";
        test2Ranking.addUser(testUser,testScore);
        test2Ranking.addUser(testUser2,testScore);
        test2Ranking.addUser(testUser3,testScore);
        test2Ranking.removeUser(testUser);
        assertEquals(2,test2Ranking.getScore(testScore).size());
    }
    @Test
    void updateUserScoreTest(){
        Ranking.reset();
        Ranking testRanking = Ranking.getInstance();
        String testUser = "RandomUser";
        int testScore = 15;
        testRanking.addUser(testUser,testScore);
        testRanking.updateUserScore(testUser,testScore+15);
        assertNotNull(testRanking.getScore(testScore+15));
        assertNotNull(testRanking.getScore(15));
    }
}