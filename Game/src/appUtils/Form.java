package appUtils;


// -CÓDIGO INTRODUCTORIO-
//PONER NUMERO DE IDENT. A CADA OPERACION QUE USE FORM [0 - 3]
//VER CÓMO ENLAZAR CON LOS ALMACENES



import java.sql.SQLOutput;

public class Form {
    private int numberOf;
    public void getLabels(int inputs){
        this.numberOf = inputs;
    }

    private void singUp(){
        String firstLabel = "nickname";
        String secondLabel = "password";
        System.out.println(firstLabel);
        System.out.println(secondLabel);
    }

    private void logIn(){
        String firstLabel = "nickname";
        String secondLabel = "password";
        System.out.println(firstLabel);
        System.out.println(secondLabel);
    }

    private void banOrUnban(){
        String firstLabel = "nickname";
        System.out.println(firstLabel);
    }

    private void requestBattle(){
        String firstLabel = "nickname";
        System.out.println(firstLabel);
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

    public void runForm(int ident){
        getLabels(ident);
        generateLabels();
    }
}
