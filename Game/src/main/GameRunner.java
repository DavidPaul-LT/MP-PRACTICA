package main;

import screen.General.Screen;
import screen.ScreenMain;
//import storage.Storage;

//import java.util.HashSet;

public class GameRunner {
    public void run() {
        //Storage gameStorage = Storage.getInstance();
        //gameStorage.setValue("Client Set",new HashSet<String>());
        //gameStorage.setValue("Operator Set",new HashSet<String>());
        Screen firstScreen = new ScreenMain("Bienvenido a Noche de batallas: el juego de rol multijugador");
    }
}
