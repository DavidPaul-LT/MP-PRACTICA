package character;

import interfaces.Factory;

import java.io.Serializable;

public class CharacterFactory implements Factory {

    private  VampireFactory vf;
    private WerewolfFactory wf;

    private HunterFactory hf;


    public CharacterFactory(){

        vf = new VampireFactory();

        wf = new WerewolfFactory();

        hf = new HunterFactory();


    }

    @Override
    public Character create() {
        return null;
    }
}
