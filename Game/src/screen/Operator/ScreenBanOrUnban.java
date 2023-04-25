package screen.Operator;

import screen.General.Screen;
import screen.ScreenOperatorMenu;
import user.Operator;
import user.UserManager;

import java.util.Scanner;

public class ScreenBanOrUnban extends Screen {
    private Operator user;
    private Scanner scanner = new Scanner(System.in);
    private int option;

    public ScreenBanOrUnban(String title, Operator user) {
        super(title);
        this.loadOptions();
        this.getOption();
        this.user = user;
    }

    @Override
    public void getOption() {
        System.out.print("Usuario: ");
        String userNick = this.scanner.nextLine();
        UserManager userManager = new UserManager();
        if (this.option == 1 && !userManager.isUserBaned(userNick)){
            user.banUser(userNick);
            System.out.println("Jugador" + userNick + "baneado");
        } else if (this.option == 2 && userManager.isUserBaned(userNick)) {
            user.unbanUser(userNick);
            System.out.println("Jugador" + userNick + "desbaneado");
        }
        scanner.nextLine();
        new ScreenOperatorMenu("Inicio Operador",this.user);
    }

    @Override
    public void loadOptions() {
        System.out.println("Banear [1]");
        System.out.println("Desbanear [2]");
        System.out.print("Seleccion: ");
        this.option = this.scanner.nextInt();
        if(this.option == 1){
            System.out.print("---BANEAR---");
        }else{
            System.out.print("---DESBANEAR---");
        }
    }
}
