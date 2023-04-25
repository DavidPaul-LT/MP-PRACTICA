package main;

import screen.Screen;
import screen.ScreenMain;
//import storage.Storage;

//import java.util.HashSet;

public class GameRunner {
    public void run() {
        //Storage gameStorage = Storage.getInstance();
        //gameStorage.setValue("Client Set",new HashSet<String>());
        //gameStorage.setValue("Operator Set",new HashSet<String>());
        Screen firstScreen = new ScreenMain("Main Screen");
    }
}
