package ScreenClass;

import java.util.Scanner;

public class ScreenClientMenu extends Screen{
    private int option;

    private Scanner scanner = new Scanner(System.in);
    public ScreenClientMenu(String title) {
        super(title);
        showOptions();
        getOptions();
    }


    @Override
    public void getOptions() {
        switch (this.option){
            case 1:
                //TODO añadir role screen
                break;
            case 2:
                //TODO eliminar role screen
                break;
            case 3:
                //TODO enviar desafío screen
                break;
            case 4:
                //TODO historial screen
                break;
            case 5:
                //TODO ranking screen
                break;
            case 6:
                Screen pantallaPrincipal = new ScreenMain("Bienvenido a Noche de batallas: el juego de rol multijugador");
                break;
            default:
                showOptions();
        }

    }

    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
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
