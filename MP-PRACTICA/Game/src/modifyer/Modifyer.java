package modifyer;

import java.io.Serializable;

public class Modifyer implements Serializable {
    private final String name;
    private final int MIN_VALUE;
    private final int MAX_VALUE;
    private final int value;
    public Modifyer(String name){
        this.name = name;
        MIN_VALUE = 1;
        MAX_VALUE = 5;
        this.value = MAX_VALUE;
    }
    public Modifyer(String name, int min_val, int max_val,int value){
        this.name = name;
        MIN_VALUE = min_val;
        MAX_VALUE = max_val;
        this.value = value;
    }
    public String getName() {
        return name;
    }
    public int getMIN_VALUE() {
        return MIN_VALUE;
    }
    public int getMAX_VALUE() {
        return MAX_VALUE;
    }
    public int getValue() {
        return value;
    }
    public Modifyer setName(String newName) {
        return new Modifyer(newName);
    }
    public Modifyer setMinValue(int newValue) {
        return new Modifyer(this.name,newValue,MAX_VALUE,this.value);
    }
    public Modifyer setMaxValue(int newValue) {
        return new Modifyer(this.name,MIN_VALUE,newValue,this.value);
    }
    public Modifyer setValue(int newValue) {
        return new Modifyer(this.name,MIN_VALUE,MAX_VALUE,newValue);
    }
}