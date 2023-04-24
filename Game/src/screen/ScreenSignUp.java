package screen;

import user.*;

import java.util.Scanner;

public class ScreenSignUp extends Screen{
    private String name;
    private String nickName;
    private String password;
    private String isOperator;
    private Scanner inputs = new Scanner(System.in);
    public ScreenSignUp(String title){
        super(title);
        this.loadOptions();
        this.getOption();
    }

    @Override
    public void getOption(){
        UserFactory userFactory = new UserFactory();
        if (!userFactory.checkUser(this.nickName,this.password)){
            User newUser;
            if (this.isOperator.equals("S")){
                OperatorBuilder newOperatorCreator = new OperatorBuilder();
                newOperatorCreator.setName(this.name);
                newOperatorCreator.setNick(this.nickName);
                newOperatorCreator.setPassword(this.password);
                try {
                    newUser = newOperatorCreator.build();
                    userFactory.create("User:"+this.nickName,newUser);
                } catch (InstantiationException e) {
                    System.out.println("La contraseña debe tener un tamaño mínimo de 8 caracteres y uno máximod de 12\nPulsa enter para reintentarlo");
                    inputs.nextLine();
                    new ScreenSignUp("Introduce otra contraseña");
                }
            }else if (this.isOperator.equals("N")){
                ClientBuilder newClientCreator = new ClientBuilder();
                newClientCreator.setNick(this.nickName);
                newClientCreator.setPassword(this.password);
                newClientCreator.setName(this.name);
                try {
                    newUser = newClientCreator.build();
                    userFactory.create("User:"+this.nickName,newUser);
                } catch (InstantiationException e) {
                    System.out.println("La contraseña debe tener un tamaño mínimo de 8 caracteres y uno máximod de 12\nPulsa enter para reintentarlo");
                    inputs.nextLine();
                    new ScreenSignUp("Introduce otra contraseña");
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
        System.out.println("Registrarse");
        System.out.print("Nombre: ");
        this.name = inputs.nextLine();
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
        System.out.print("¿Será esta una cuenta de operador [S/N]: ");
        this.isOperator = inputs.nextLine();
    }

}
