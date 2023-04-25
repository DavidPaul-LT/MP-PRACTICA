package screen;

import screen.General.Screen;
import user.UserManager;

import java.util.Scanner;

public class DeleteAccountScreen extends Screen {
    private String userNick;
    private String userPassword;
    private Scanner scanner = new Scanner(System.in);

    public DeleteAccountScreen(String title) {
        super(title);
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption(){
        UserManager userManager = new UserManager();
        if (userManager.checkUser(this.userNick,this.userPassword)){
            userManager.delete(this.userNick);
            System.out.println("El usuario " + this.userNick + " ha sido eliminado de forma exitosa");
        }else{
            System.out.println("El usuario " + this.userNick + " no pudo ser eliminado");
        }
        scanner.nextLine();
        new ScreenMain("Bienvenido");
    }

    @Override
    public void loadOptions() {
        System.out.print("Nick de usuario: ");
        this.userNick = scanner.nextLine();
        System.out.print("Constraseña de usuario: ");
        this.userPassword = scanner.nextLine();
    }

}
