package ScreenClass;

import java.util.Scanner;

public class ScreenBattleRequest extends Screen{
    //TODO private Cliente cliente;
    private String cliente;

    private final Scanner scanner = new Scanner(System.in);

    public ScreenBattleRequest(String title) {
        super(title);
        showOptions();
        getOptions();
    }


    @Override
    public void getOptions() {
        if(cliente == null){
            showOptions();
        }else{
            //TODO Battle's Screen
        }
    }

    @Override
    public void showOptions() {
        System.out.println(this.getTitle());
        System.out.print("Retar a jugador: ");
        this.cliente = scanner.nextLine();
    }
}
