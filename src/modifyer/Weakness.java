package modifyer;

public class Weakness extends Modifyer{
    public Weakness(String name) {
        super(name);
    }

    @Override
    public int getValue() {
        return super.getValue()*-1;
    }
    @Override
    public Modifyer setName(String newName) {
        return null;
    }

    @Override
    public Modifyer setMinValue(int newValue) {
        return null;
    }

    @Override
    public Modifyer setMaxValue(int newValue) {
        return null;
    }

    @Override
    public Modifyer setValue(int newValue) {
        return null;
    }
}
