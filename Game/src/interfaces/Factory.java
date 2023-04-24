package interfaces;

import storage.Storage;

import java.io.Serializable;

public interface Factory {
    public default Serializable create(String objectName, Serializable object){
        Storage storage = Storage.getInstance();
        storage.setValue(objectName,object);
        return object;
    }
}
