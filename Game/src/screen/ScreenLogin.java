package screen;

import storage.Storage;
import user.User;
import user.UserManager;

import java.util.HashSet;
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
        UserManager userManager = new UserManager();
        if (userManager.checkUser(this.nickName,this.password)){
            User user = userManager.getUser(this.nickName);
            HashSet<String> clientSet = (HashSet<String>) Storage.getInstance().getValue("Client Set");
            if (clientSet.contains(this.nickName)){
                new ScreenClientMenu("Inicio cliente", userManager.getUser("User:"+this.nickName));
            }else{
                //TODO Operator menu
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos\nPulsa enter para iniciar sesión");
            inputs.nextLine();
            new ScreenLogin("Iniciar sesión");
        }
    }

    @Override
    public void loadOptions() {
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
    }

}
