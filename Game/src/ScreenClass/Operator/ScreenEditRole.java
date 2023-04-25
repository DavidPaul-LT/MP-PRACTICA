package ScreenClass.Operator;

import ScreenClass.Screen;

import java.util.Scanner;

public class ScreenEditRole extends Screen {
    private int option;
    private Scanner scanner = new Scanner(System.in);
    public ScreenEditRole(String title) {
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
