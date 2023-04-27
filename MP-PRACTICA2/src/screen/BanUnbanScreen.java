package screen;

import interfaces.Screen;
import user.Operator;

import java.util.Scanner;

public class BanUnbanScreen implements Screen {
    public static final String TITLE = "Administrar cuentas";
    private Operator user;
    public BanUnbanScreen(Operator user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        System.out.print("Nick del usuario: ");
        String userNick = scanner.nextLine();
        switch (option){
            case 1:
                this.user.banUser(userNick);
                System.out.println("El usuario fue baneado");
                scanner.nextLine();
                new OperatorMenuScreen(this.user);
                break;
            case 2:
                this.user.unbanUser(userNick);
                System.out.println("El usuario fue desbaneado");
                scanner.nextLine();
                new OperatorMenuScreen(this.user);
                break;
            case 3:
                new OperatorMenuScreen(this.user);
                break;
            default:
                this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        System.out.println("Banear usuario [1]");
        System.out.println("Desbanear usuario [2]");
        System.out.println("Salir [3]");
        System.out.print("Selección: ");
        this.getOption();
    }
}
