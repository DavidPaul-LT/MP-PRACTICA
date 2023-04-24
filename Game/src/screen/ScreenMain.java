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
    public void getOption() {
        this.option = scanner.nextInt();
        switch (option) {
            case 1:
                //Screen signUp = new ScreenSingUp("SignUp");
                //TODO Sign Up user's account
                break;
            case 2:
                Screen logIn = new ScreenLogin("Inicar sesión");
                break;
            case 3:
                //TODO Remove user's account
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

    @Override
    public void loadForm() {

    }
}