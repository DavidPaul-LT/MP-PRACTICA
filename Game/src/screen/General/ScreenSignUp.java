package screen.General;

import screen.General.Screen;
import screen.ScreenClientMenu;
import screen.ScreenLogin;
import screen.ScreenMain;
import screen.ScreenOperatorMenu;
import storage.Storage;
import user.*;

import java.util.HashSet;
import java.util.Scanner;

public class ScreenSignUp extends Screen {
    private String name;
    private String nickName;
    private String password;
    private String isOperator;
    private Scanner inputs = new Scanner(System.in);
    public ScreenSignUp(String title){
        super(title);
        this.loadOptions();
    }

    @Override
    public void getOption(){
        UserManager userManager = new UserManager();
        if (!userManager.checkUser(this.nickName,this.password)){
            User newUser;
            if (this.isOperator.equals("S")){
                OperatorBuilder newOperatorCreator = new OperatorBuilder();
                newOperatorCreator.setName(this.name);
                newOperatorCreator.setNick(this.nickName);
                newOperatorCreator.setPassword(this.password);
                try {
                    newUser = newOperatorCreator.build();
                    userManager.create("User:"+this.nickName,newUser);
                    Storage auxStorage = Storage.getInstance();
                    HashSet<String> auxClientSet = (HashSet<String>) auxStorage.getValue("Operator Set");
                    auxClientSet.add(this.nickName);
                    Storage.getInstance().setValue("Operator Set",auxClientSet);
                    new ScreenOperatorMenu("Inicio Operador",newUser);
                } catch (InstantiationException e) {
                    System.out.println("La contraseña debe tener un tamaño mínimo de 8 caracteres y uno máximod de 12\nPulsa enter para reintentarlo");
                    inputs.nextLine();
                    this.addSpacing();
                    this.loadOptions();
                }
            }else if (this.isOperator.equals("N")){
                ClientBuilder newClientCreator = new ClientBuilder();
                newClientCreator.setNick(this.nickName);
                newClientCreator.setPassword(this.password);
                newClientCreator.setName(this.name);
                try {
                    newUser = newClientCreator.build();
                    userManager.create("User:"+this.nickName,newUser);
                    Storage auxStorage = Storage.getInstance();
                    HashSet<String> auxClientSet = (HashSet<String>) auxStorage.getValue("Client Set");
                    auxClientSet.add(this.nickName);
                    auxClientSet.add(this.nickName);
                    Storage.getInstance().setValue("Client Set",auxClientSet);
                    new ScreenClientMenu("Inicio cliente", newUser);
                } catch (InstantiationException e) {
                    System.out.println("La contraseña debe tener un tamaño mínimo de 8 caracteres y uno máximod de 12\nPulsa enter para reintentarlo");
                    this.addSpacing();
                    this.loadOptions();
                }
            }else{
                System.out.println("¿Cómo coño has llegado hasta aquí\nPulsa enter para volver");
                inputs.nextLine();
                new ScreenMain("Bienvenido");
            }
        } else {
            System.out.println("La cuenta ya existe\nPulsa enter para iniciar sesión");
            inputs.nextLine();
            new ScreenLogin("Iniciar sesión");
        }
    }

    @Override
    public void loadOptions() {
        System.out.print("Nombre: ");
        this.name = inputs.nextLine();
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
        System.out.print("¿Será esta una cuenta de operador [S/N]: ");
        this.isOperator = inputs.nextLine();
        this.getOption();
    }

}
