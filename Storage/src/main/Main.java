package main;

import minion.Minion;

public class Main {
    public static void main(String[] args){
        Storage st = Storage.getInstance();
        Minion minion = new Minion("Mateo");
        st.addToValue("Hola",minion);
        System.out.println(st.getValue("Hola"));
    }
}
