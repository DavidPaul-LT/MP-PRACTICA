package screen;

import app_utils.Ranking;
import interfaces.Screen;
import user.Client;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RankingScreen implements Screen {
    public static final String TITLE = "Ranking";
    private Client user;
    public RankingScreen(Client user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Ranking ranking = Ranking.getInstance();
        for(Integer i: ranking.getRankingValues()){
            PriorityQueue<String> names = ranking.getScorePosition(i);
            System.out.print(i + " - ");
            for (String name:names) {
                System.out.print(name + " - ");
            }
            System.out.println();
        }
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        new ClientMenuScreen(this.user);
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
