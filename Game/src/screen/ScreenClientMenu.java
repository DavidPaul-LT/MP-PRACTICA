package screen;

import user.Client;
import user.User;

import java.util.Scanner;

public class ScreenClientMenu extends Screen{
    private int option;
    private User user;
    private Scanner scanner = new Scanner(System.in);
    protected ScreenClientMenu(String title, User user) {
        super(title);
        this.user = user;
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption(){
        switch (this.option){
            case 1:
                //TODO añadir role screen
                break;
            case 2:
                //TODO eliminar role screen
                break;
            case 3:
                new ScreenBattleRequest("Enviar desafío", (Client) this.user);
                break;
            case 4:
                //TODO historial screen
                break;
            case 5:
                //TODO ranking screen
                break;
            case 6:
                new ScreenMain("Bienvenido a Noche de batallas: el juego de rol multijugador");
                break;
            default:
                new ScreenClientMenu("Inicio cliente",this.user);
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Añadir rol [1]");
        System.out.println("Eliminar rol [2]");
        System.out.println("Enviar Desafío [3]");
        System.out.println("Historial [4]");
        System.out.println("Ranking [5]");
        System.out.println("Salir Menú [6]");
        System.out.print("Seleccion: ");
        this.option = scanner.nextInt();
    }
}
