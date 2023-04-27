package src.screen;

import src.interfaces.Screen;
import src.user.Client;

import java.util.Scanner;

public class CambatHistoryScreen implements Screen {
    public static final String TITLE = "Mis combates";
    private Client user;
    public CambatHistoryScreen(Client user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        //TODO Show last combats
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
