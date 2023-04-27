package screen;

import interfaces.Screen;
import user.Client;
import user.User;

import java.util.Scanner;

public class ClientMenuScreen implements Screen {
    public static String TITLE = "Menú de jugador";
    private Client user;
    public ClientMenuScreen(User user) {
        this.user = (Client) user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                //TODO Add RoleCustomizationScreen
                break;
            case 2:
                new BattleRequestScreen(this.user);
                break;
            case 3:
                new CambatHistoryScreen(this.user);
                break;
            case 4:
                new RankingScreen(this.user);
                break;
            case 5:
                new DeleteAccountScreen(this.user);
                break;
            case 6:
                new MainScreen();
                break;
            default:
                this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        if (user.getChallenge() != null){
            System.out.println("Tienes una batalla pendiente");
        }
        System.out.println("Personalizar rol [1]");
        System.out.println("Desafiar [2]");
        System.out.println("Mis combates [3]");
        System.out.println("Ver ranking [4]");
        System.out.println("Borrar cuenta [5]");
        System.out.println("Cerrar sesión [6]");
        System.out.print("Seleccion: ");
        this.getOption();
    }
}
