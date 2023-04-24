package ScreenClass;

import java.util.Scanner;

public class ScreenSingUp extends Screen{

    private String user;
    private String password;
        Scanner scanner = new Scanner(System.in);
    public ScreenSingUp(String title) {
        super(title);
        showOptions();
        getOptions();

    }

    @Override
    public void getOptions() {

    }
    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
        System.out.print("Usuario: ");
        this.user = scanner.nextLine();
        System.out.print("Contraseña: ");
        this.password = scanner.nextLine();

    }
}
