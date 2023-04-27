package src.interfaces;

public interface Screen {
    // get different operations to execute an action
    public void getOption();

    // shows all available operations to execute them
    public void loadOptions();

    // gives a space to print operations at the end
    public static void addSpacing(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
