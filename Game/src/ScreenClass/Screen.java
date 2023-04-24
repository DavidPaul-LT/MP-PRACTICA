package ScreenClass;

public abstract class Screen {
    private String title;

    public Screen(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract void getOptions();

    public abstract void showOptions();
}
