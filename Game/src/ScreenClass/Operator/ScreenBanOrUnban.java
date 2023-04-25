package ScreenClass.Operator;

import ScreenClass.Screen;

import java.util.Scanner;

public class ScreenBanOrUnban extends Screen {
    private String user;
    private int option;
    private Scanner scanner = new Scanner(System.in);

    public ScreenBanOrUnban(String title) {
        super(title);
        showOptions();
        getOptions();
    }

        @Override
        public void getOptions() {
        System.out.println(this.getTitle());
        System.out.print("Usuario: ");
        this.user = scanner.nextLine();
        banOrUnban();
    }
        public void banOrUnban(){
        if(option == 1 && this.user == null){
            System.out.println("El usuario " + this.user + " ha sido baneado");
        }else{
            System.out.println("El usuario " + this.user + "ha sido desbaneado");
        }
    }

        @Override
        public void showOptions() {
        System.out.println(this.getTitle());
        System.out.println("Banear [1]");
        System.out.println("Desbanear [2]");
        System.out.print("Seleccion: ");
        this.option = scanner.nextInt();
        if(option == 1){
            this.setTitle("Pantalla Baneo");
        }else{
            this.setTitle("Pantalla Desbaneo");
        }
    }
}
