package ScreenClass.Operator;

import ScreenClass.Screen;
import ScreenClass.Client.ScreenBattleRequest;
import ScreenClass.ScreenMain;

import java.util.Scanner;

public class ScreenOperatorScreen extends Screen {
    private int option;

    private final Scanner scanner = new Scanner(System.in);
    public ScreenOperatorScreen(String title) {
        super(title);
        showOptions();
        getOptions();
    }

    @Override
    public void getOptions() {
        switch(this.option){
            case 1:
                Screen pantallaEditarAlmacen = new ScreenEditStorage("Editar Almacen");
                break;
            case 2:
                Screen pantallaEditarRole = new ScreenEditRole("Editar Roll");
                break;
            case 3:
                Screen pantallaRetarBatalla = new ScreenBattleRequest("Desafia");
                break;
            case 4:
                Screen pantallaBanOrUnban = new ScreenBanOrUnban("Administrar Cuenta");
                break;
            case 5:
                Screen pantallaPrincipal = new ScreenMain("Bienvenido a Noche de batallas: el juego de rol multijugador");
                break;
            default:
                showOptions();

        }
    }

    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
        System.out.println("Editar Almacen [1]");
        System.out.println("Editar Personajes [2]");
        System.out.println("Validar Peticiones de batalla [3]");
        System.out.println("Administrar Cuentas [4]");
        System.out.println("Salir Menú [5]");
        System.out.print("Seleccion: ");
        this.option = scanner.nextInt();
    }
}
