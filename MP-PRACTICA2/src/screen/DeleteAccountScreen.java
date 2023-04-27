package screen;

import interfaces.Screen;
import user.User;
import user.UserManager;

import java.util.Scanner;


public class DeleteAccountScreen implements Screen {
    public static final String TITLE = "¿Estás seguro de querrer borrar tu cuenta? [S/N]";
    private User user;
    public DeleteAccountScreen(User user){
        this.user = user;
        this.loadOptions();
    }
    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()){
            case "S":
                UserManager userManager = new UserManager();
                userManager.delete(this.user.getNick());
                System.out.println("Tu cuenta ha sido borrada");
                scanner.nextLine();
                new MainScreen();
                break;
            case "N":
                new ClientMenuScreen(this.user);
                break;
            default:
                this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
