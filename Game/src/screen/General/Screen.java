package screen.General;

public abstract class Screen {
    private String title;

    protected Screen(String title) {
        this.addSpacing();
        this.title = title;
        System.out.println(title);
    }

    public abstract void getOption();

    public abstract void loadOptions();

    public void addSpacing(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}