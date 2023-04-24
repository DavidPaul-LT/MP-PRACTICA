package ScreenClass;

import java.nio.FloatBuffer;

public class ScreenLogin extends Screen{

    public ScreenLogin(String title) {
        super(title);
        loadForm();
    }

    public void loadForm(){
        Form load = new Form();
        load.logIn();
    }

}
