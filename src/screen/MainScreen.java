package screen;

import interfaces.Screen;

import java.util.Scanner;

public class MainScreen implements Screen {
    public static final String TITLE = "Bienvenido";
    public MainScreen(){
        this.loadOptions();
    }
    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                new SignUpScreen();
                break;
            case 2:
                new LogInScreen();
                break;
            case 3:
                break;
            default:
                this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        System.out.println("Registrarse [1]");
        System.out.println("Iniciar sesión [2]");
        System.out.println("Salir de la app [3]");
        System.out.print("Seleccion: ");
        this.getOption();
    }
}
