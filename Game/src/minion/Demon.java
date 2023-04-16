package minion;

import interfaces.Master;
import java.util.List;

public class Demon extends Minion implements Master {
    private List<Minion> minions; //Composite design pattern ??
    private Pact pact;
    public Demon(String name, Pact pact){
        super(name);
        this.pact = pact;
    }
}
