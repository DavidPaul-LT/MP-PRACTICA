package interfaces;

public interface Screen {
    public void getOption();
    public void loadOptions();
    public static void addSpacing(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
