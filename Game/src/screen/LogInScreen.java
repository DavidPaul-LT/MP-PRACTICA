package screen;

import interfaces.Screen;
import storage.Storage;
import user.Operator;
import user.User;
import user.UserManager;

import java.util.HashSet;
import java.util.Scanner;

public class LogInScreen implements Screen {
    public static final String TITLE = "Inicar sesión";
    private Scanner scanner = new Scanner(System.in);
    private String nickName;
    private String password;

    public LogInScreen(){
        this.loadOptions();
    }
    @Override
    public void getOption() {
        UserManager userManager = new UserManager();
        if (userManager.checkUser(this.nickName,this.password)){
            HashSet<String> clientSet = (HashSet<String>) Storage.getInstance().getValue("Client Set");
            if (clientSet.contains(this.nickName)){
                new ClientMenuScreen(userManager.getUser(this.nickName));
            }else {
                new OperatorMenuScreen((Operator) userManager.getUser(this.nickName));
            }
        }else {
            System.out.println("Usuario o contraseña incorrectos\nPulsa enter para iniciar sesión");
            scanner.nextLine();
            this.loadOptions();
        }
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        System.out.print("Usuario: ");
        this.nickName = scanner.nextLine();
        System.out.print("Constraseña: ");
        this.password = scanner.nextLine();
        this.getOption();
    }
}
