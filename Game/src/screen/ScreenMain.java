package screen;


import java.util.Scanner;

public class ScreenMain extends Screen {
    private int option;
    Scanner scanner = new Scanner(System.in);

    public ScreenMain(String title) {
        super(title);
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption(){
        this.option = scanner.nextInt();
        switch (option) {
            case 1:
                new ScreenSignUp("Registrarse");
                break;
            case 2:
                new ScreenLogin("Inicar sesión");
                break;
            case 3:
                new DeleteAccountScreen("Borrar cuenta");
                break;
            default:
                System.out.println("Hasta pronto");
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Bienvenido a Noche de batallas: el juego de rol multijugador");
        System.out.println("Registrarse [1]");
        System.out.println("Iniciar sesión [2]");
        System.out.println("Borrar cuenta [3]");
        System.out.println("EXIT []");
    }
}