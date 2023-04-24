package screen;

public abstract class Screen {
    private String title;

    protected Screen(String title) {
        this.addSpacing();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void getOption() throws InstantiationException;

    public abstract void loadOptions();

    public void addSpacing(){
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}