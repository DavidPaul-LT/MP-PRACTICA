package screen;

import user.UserFactory;

import java.util.Scanner;

public class DeleteAccountScreen extends Screen{
    private String userNick;
    private String userPassword;
    //TODO Enlazar con el operador para que al eliminar
    //aparezca por pantalla quien ha eliminado al jugador x
    // private Operator operatorName;
    private Scanner scanner = new Scanner(System.in);

    public DeleteAccountScreen(String title) {
        super(title);
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption(){
        UserFactory userFactory = new UserFactory();
        if (userFactory.checkUser(this.userNick,this.userPassword)){
            userFactory.delete(this.userNick);
            System.out.println("El usuario " + this.userNick + " ha sido eliminado de forma exitosa");
        }else{
            System.out.println("El usuario " + this.userNick + " no pudo ser eliminado");
        }
        scanner.nextLine();
        new ScreenMain("Bienvenido");
    }

    @Override
    public void loadOptions() {
        System.out.print("Nick de usuario: ");
        this.userNick = scanner.nextLine();
        System.out.print("Constraseña de usuario: ");
        this.userPassword = scanner.nextLine();
    }

}
