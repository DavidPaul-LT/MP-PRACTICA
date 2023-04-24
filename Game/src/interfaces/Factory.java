package interfaces;

import java.io.Serializable;

public interface Factory {
    public Serializable create() throws InstantiationException;
}
