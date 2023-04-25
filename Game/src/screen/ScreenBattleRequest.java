package screen;

import screen.General.Screen;
import user.Client;

import java.util.Scanner;

public class ScreenBattleRequest extends Screen {
    private String challengedNick;
    private Scanner scanner = new Scanner(System.in);
    private int bet;
    private Client user;

    public ScreenBattleRequest(String title, Client user) {
        super(title);
        this.user = user;
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption() {
        new ScreenClientMenu("Inicio Cliente",this.user);
    }

    @Override
    public void loadOptions() {
        do {
            System.out.print("Retar a jugador: ");
            this.challengedNick = scanner.nextLine();
            System.out.print("Apostar: ");
            this.bet = scanner.nextInt();
        }
        while (!this.user.sendBattleRequest(this.challengedNick, this.bet));
        new ScreenClientMenu("Inicio Cliente",this.user);
    }
}
