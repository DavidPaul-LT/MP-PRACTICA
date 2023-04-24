package ScreenClass;

import java.util.Scanner;

public class DeleteAccountScreen extends Screen{
    private String user;
    //TODO Enlazar con el operador para que al eliminar
    //aparezca por pantalla quien ha eliminado al jugador x
    // private Operator operatorName;
    private Scanner scanner = new Scanner(System.in);

    public DeleteAccountScreen(String title) {
        super(title);
        showOptions();
        getOptions();
    }


    @Override
    public void getOptions() {
        System.out.println("El usuario " + this.user + " ha sido eliminado por " + "this.operator.getName())");
        //...
    }

    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
        System.out.print("Usuario: ");
        this.user = scanner.nextLine();
    }
}
