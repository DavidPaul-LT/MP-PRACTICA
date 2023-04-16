package modifyer;

import interfaces.Factory;

import java.io.Serializable;

public abstract class ModifyerFactory implements Factory {
    @Override
    public Modifyer create() {
        return null;
    }
}
