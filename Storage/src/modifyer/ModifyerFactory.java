package modifyer;

import interfaces.Factory;

public abstract class ModifyerFactory implements Factory {
    public abstract Modifyer create(Boolean extended);
}
