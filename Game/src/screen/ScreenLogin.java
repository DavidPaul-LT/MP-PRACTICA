package screen;

import user.ClientFactory;
import user.User;
import user.UserFactory;

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
        UserFactory userFactory = new UserFactory();
        if (userFactory.checkUser(this.nickName,this.password)){
            User user = userFactory.getUser(this.nickName);
            //TODO Profile's screen.
        } else {
            //TODO Passwords do not match.
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Iniciar sesión");
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
    }

}
