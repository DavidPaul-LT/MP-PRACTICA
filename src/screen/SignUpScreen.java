package screen;

import app_utils.Ranking;
import interfaces.Screen;
import user.*;

import java.util.Scanner;

public class SignUpScreen implements Screen {
    public static String TITLE = "Registrarse";
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private String nickName;
    private String password;
    private String isOperator;

    public SignUpScreen(){
        this.loadOptions();
    }
    @Override
    public void getOption() {
        UserManager userManager = new UserManager();
        if (!userManager.checkUser(this.nickName,this.password)){
            User newUser;
            switch (isOperator){
                case "S":
                    OperatorBuilder newOperator = new OperatorBuilder();
                    newOperator.setName(this.name);
                    newOperator.setNick(this.nickName);
                    newOperator.setPassword(this.password);
                    try {
                        newUser = newOperator.build();
                        userManager.create("User:"+this.nickName,newUser);
                        userManager.addInOperatorSet(this.nickName);
                        new OperatorMenuScreen((Operator) newUser);
                    } catch (InstantiationException e) {
                        this.invalidSignUp();
                    }
                    break;
                case "N":
                    ClientBuilder newClient = new ClientBuilder();
                    newClient.setName(this.name);
                    newClient.setNick(this.nickName);
                    newClient.setPassword(this.password);
                    try {
                        newUser = newClient.build();
                        Ranking.getInstance().setUserScore(this.nickName,0);
                        userManager.create("User:"+this.nickName,newUser);
                        userManager.addInClientSet(this.nickName);
                        new ClientMenuScreen(newUser);
                    } catch (InstantiationException e) {
                        this.invalidSignUp();
                    }
                    break;
                default:
                    System.out.println("Registro fallido");
                    scanner.nextLine();
                    new MainScreen();
            }
        }
    }

    private void invalidSignUp() {
        System.out.println("La contraseña debe tener un tamaño mínimo de 8 caracteres y uno máximod de 12\nPulsa enter para reintentarlo");
        scanner.nextLine();
        this.loadOptions();
    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        System.out.print("Nombre: ");
        this.name = scanner.nextLine();
        System.out.print("Usuario: ");
        this.nickName = scanner.nextLine();
        System.out.print("Constraseña: ");
        this.password = scanner.nextLine();
        System.out.print("¿Será esta una cuenta de operador [S/N]: ");
        this.isOperator = scanner.nextLine();
        this.getOption();
    }
}
