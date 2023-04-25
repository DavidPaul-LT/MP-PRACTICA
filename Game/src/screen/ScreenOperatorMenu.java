package screen;

import user.Client;
import user.Operator;
import user.User;

import java.util.Scanner;

public class ScreenOperatorMenu extends Screen{
    private int option;
    private Scanner scanner = new Scanner(System.in);
    private User user;

    protected ScreenOperatorMenu(String title, User user) {
        super(title);
        this.loadOptions();
        this.getOption();
        this.user = user;
    }

    @Override
    public void getOption(){
        switch(this.option){
            case 1:
                new ScreenEditStorage("Editar Almacen");
                break;
            case 2:
                new ScreenEditRole("Editar Roll");
                break;
            case 3:
                new ScreenBattleRequest("Gestionar desafíos", (Client) this.user);
                break;
            case 4:
                new ScreenBanOrUnban("Administrar Cuenta", (Operator) this.user);
                break;
            case 5:
                new ScreenMain("Bienvenido a Noche de batallas: el juego de rol multijugador");
                break;
            default:
                new ScreenOperatorMenu("Inicio Operador", this.user);
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Editar Almacen [1]");
        System.out.println("Editar Personajes [2]");
        System.out.println("Validar Peticiones de batalla [3]");
        System.out.println("Administrar Cuentas [4]");
        System.out.println("Salir Menú [5]");
        System.out.print("Seleccion: ");
        this.option = scanner.nextInt();
    }
}
