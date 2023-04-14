package main;

import minion.Ghoul;
import minion.Minion;
import storage.Storage;

public class Main {
    public static void main(String[] args){
        Storage st = Storage.getInstance();
        Minion minion = new Ghoul("Mateo");
        st.addToValue("Hola",minion);
        System.out.println(st.getValue("Hola"));
    }
}
