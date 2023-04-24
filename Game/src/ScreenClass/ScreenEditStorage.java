package ScreenClass;

import java.util.Scanner;

public class ScreenEditStorage extends Screen{
    private int option;
    private Scanner scanner = new Scanner(System.in);

    public ScreenEditStorage(String title) {
        super(title);
        showOptions();
        getOptions();
    }

    @Override
    public void getOptions() {
        //...
    }

    @Override
    public void showOptions() {
        //...
    }
}
