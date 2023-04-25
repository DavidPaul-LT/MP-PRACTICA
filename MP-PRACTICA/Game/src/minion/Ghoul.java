package minion;

public class Ghoul extends Minion{
    private static final int MIN_DEPENDENCY = 1;
    private static final int MAX_DEPENDENCY = 5;
    private int masterDependency;
    public Ghoul(String name) {
        super(name);
    }
}
