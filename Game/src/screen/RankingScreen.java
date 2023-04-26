package screen;

import interfaces.Screen;
import user.Client;

import java.util.Scanner;

public class RankingScreen implements Screen {
    public static final String TITLE = "Ranking";
    private Client user;
    public RankingScreen(Client user) {
        //TODO RankingScreen
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        //TODO Show Ranking
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
