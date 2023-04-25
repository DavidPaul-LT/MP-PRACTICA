package screen;

import interfaces.Screen;
import main.Main;
import user.Operator;

import java.util.Scanner;

public class OperatorMenuScreen implements Screen {
    public static String TITLE = "Menú de operador";
    private Operator user;
    public OperatorMenuScreen(Operator user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                new EditStorageScreen(this.user);
                break;
            case 2:
                new EditRoleScreen(this.user);
                break;
            case 3:
                new RequestValidatorScreen(this.user);
                break;
            case 4:
                new BanUnbanScreen(this.user);
                break;
            case 5:
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
        System.out.println("Editar Almacen [1]");
        System.out.println("Editar Personajes [2]");
        System.out.println("Validar desafíos [3]");
        System.out.println("Administrar cuentas [4]");
        System.out.println("Cerrar sesión [5]");
        System.out.print("Seleccion: ");
        this.getOption();
    }
}
