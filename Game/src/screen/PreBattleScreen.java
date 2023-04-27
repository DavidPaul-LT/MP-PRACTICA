package screen;

import battle.BattleRequest;
import interfaces.Screen;
import user.User;
import user.UserManager;

import java.util.Scanner;

public class PreBattleScreen implements Screen {
    public static final String TITLE = "Pantalla precombate";
    private BattleRequest challenge;
    public PreBattleScreen(BattleRequest challenge) {
        this.challenge = challenge;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        // TODO PreBattleScreen
        System.out.println("Aquí iría la pantalla precombate");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        UserManager userManager = new UserManager();
        new ClientMenuScreen(userManager.getUser(challenge.getChallenged()));
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
