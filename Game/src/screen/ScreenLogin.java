package screen;

import user.ClientFactory;
import user.User;

import java.util.Scanner;

public class ScreenLogin extends Screen{
    private String nickName;
    private String password;
    private Scanner inputs = new Scanner(System.in);
    public ScreenLogin(String login) {
        super(login);
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption() {
        ClientFactory clientFactory = new ClientFactory();
        if (clientFactory.checkUser(this.nickName,this.password)){
            User user = clientFactory.getUser(this.nickName);
            //TODO Profile's screen.
        };
    }

    @Override
    public void loadOptions() {
        System.out.println("Iniciar sesión");
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
    }

    @Override
    public void loadForm() {

    }
}
