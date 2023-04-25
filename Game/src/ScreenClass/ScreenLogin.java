package ScreenClass;

import java.nio.FloatBuffer;
import java.util.Scanner;

public class ScreenLogin extends Screen{
    private String user;
    private String password;
    private Scanner scanner = new Scanner(System.in);

    public ScreenLogin(String title) {
        super(title);
        showOptions();
        getOptions();
    }


    @Override
    public void getOptions() {
        System.out.println("Se ha creado una cuenta el usuario " + this.user);
        //...
    }


    @Override
    public void showOptions(){
        System.out.println(this.getTitle());
        System.out.print("Usuario: ");
        this.user = scanner.nextLine();
        System.out.print("Contraseña: ");
        this.password = scanner.nextLine();
    }


}