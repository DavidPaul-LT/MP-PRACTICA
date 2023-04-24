package ScreenClass;

public class ScreenSingUp extends Screen{
    public ScreenSingUp(String title) {
        super(title);
        loadForm();
    }
    public void loadForm(){
        Form load = new Form();
        load.singUp();
    }
}
