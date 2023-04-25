package ScreenClass.Operator;

import ScreenClass.Screen;

import java.util.Scanner;

public class ScreenValidateBattleRequest extends Screen {
    private int option;
    private Scanner scanner = new Scanner(System.in);
    public ScreenValidateBattleRequest(String title) {
        super(title);
    }


    @Override
    public void getOptions() {

    }

    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
        for(int i = listBattleRequests.length; i>0; i--){
            System.out.println("Validar Reto batalla " + "[" + Integer.toString(i) + "]");
        }
        this.option = scanner.nextInt();
    }
}
