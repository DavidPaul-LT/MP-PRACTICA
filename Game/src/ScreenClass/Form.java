package ScreenClass;// -CÓDIGO INTRODUCTORIO-
//PONER NUMERO DE IDENT. A CADA OPERACION QUE USE FORM [0 - 3]
//VER CÓMO ENLAZAR CON LOS ALMACENES



import java.sql.SQLOutput;
import java.util.Scanner;

public class Form {
    private int numberOf;
    private String nickname;
    private String password;
    Scanner scanner = new Scanner(System.in);



    public void singUp(){
        this.nickname = scanner.nextLine();
        this.password = scanner.nextLine();
        System.out.println(this.nickname + " " + this.password);
    }

    public void logIn(){
        this.nickname = scanner.nextLine();
        this.password = scanner.nextLine();
        System.out.println(this.nickname + " " + this.password);

    }

    public void banOrUnban(){
        System.out.println("nickname");
        this.nickname = scanner.nextLine();
        System.out.println(this.nickname);
    }

    public void requestBattle(){
        System.out.println("nickname");
        this.nickname = scanner.nextLine();
        System.out.println(this.nickname);
    }


    public void generateLabels(){
        switch (this.numberOf){
            case 0:
                singUp();
                break;
            case 1:
                logIn();
                break;
            case 2:
                banOrUnban();
                break;
            case 3:
                requestBattle();
                break;
        }
    }
}
