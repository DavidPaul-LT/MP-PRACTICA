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
                //TODO Operator creation
            }else if (this.isOperator.equals("N")){
                ClientBuilder newClientCreator = new ClientBuilder();
                newClientCreator.setNick(this.nickName);
                newClientCreator.setPassword(this.password);
                newClientCreator.setName(this.name);

            }
        } else {
            //TODO User already exists
        }
    }

    @Override
    public void loadOptions() {
        System.out.println("Iniciar sesión");
        System.out.print("Usuario: ");
        this.nickName = inputs.nextLine();
        System.out.print("Constraseña: ");
        this.password = inputs.nextLine();
        System.out.print("¿Será esta una cuenta de operador [S/N]: ");
        this.isOperator = inputs.nextLine();
    }

}
