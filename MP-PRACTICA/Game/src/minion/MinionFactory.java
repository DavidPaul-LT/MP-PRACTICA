package minion;

import interfaces.Factory;

public abstract class MinionFactory implements Factory {

    private  HumanFactory hf;
    private  GhoulFactory gf;

    private DemonFactory dm;



    public MinionFactory(){
        hf = new HumanFactory();
        gf = new GhoulFactory();
        dm = new DemonFactory();
    }


    public Minion createMinion(){

        return null;
    }
}
