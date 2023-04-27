package src.screen;

import src.app_utils.Ranking;
import src.interfaces.Screen;
import src.storage.Storage;
import src.user.Client;

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
        Ranking.getInstance().setUserScore("David", 6);
        Ranking.getInstance().setUserScore("Roberto", 130);
        Ranking.getInstance().setUserScore("Liz", 1);
        for(Integer i:Ranking.getInstance().getRankingValues()){
            System.out.println(i+": "+Ranking.getInstance().getScorePosition(i).element());
        }

        System.out.println("Presiona enter para salir del Ranking");
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
