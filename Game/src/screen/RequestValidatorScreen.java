package screen;

import interfaces.Screen;
import user.Operator;

public class RequestValidatorScreen implements Screen {
    public static final String TITLE = "Validar desafíos pendientes";
    private Operator user;
    public RequestValidatorScreen(Operator user) {
        this.user = user;
        this.loadOptions();
    }

    @Override
    public void getOption() {

    }

    @Override
    public void loadOptions() {
        Screen.addSpacing();
        System.out.println(TITLE);
        this.getOption();
    }
}
