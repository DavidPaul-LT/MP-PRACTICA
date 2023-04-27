package src.screen;

import src.interfaces.Screen;
import src.storage.Storage;
import src.user.Client;

import java.util.Scanner;

public class BattleRequestScreen implements Screen {
    public static String TITLE = "Desafiar jugador";
    private Client user;
    public BattleRequestScreen(Client user){
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        String challengedNick;
        int bet;
        do {
            //Storage.getInstance().returnClientNames();
            System.out.print("Nick del jugador: ");
            challengedNick = scanner.nextLine();
            System.out.print("Apostar: ");
            bet = scanner.nextInt();
        }
        while (!this.user.sendBattleRequest(challengedNick, bet));
        new ClientMenuScreen(this.user);
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
