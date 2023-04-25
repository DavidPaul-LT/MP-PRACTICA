package modifyer;

import interfaces.Factory;

import java.io.Serializable;

public abstract class ModifyerFactory implements Factory {

    private  FortressFactory ff;

    private WeaknessFactory wf;


    public ModifyerFactory() {

        ff = new FortressFactory();

        wf = new WeaknessFactory();

    }

    @Override
    public Modifyer create() {
        return null;
    }
}
