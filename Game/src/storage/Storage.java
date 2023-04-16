package storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storage implements Serializable{
    private static final String DEFAULT_PATH = "DEFAULT";
    private static Storage instance;
    private String path;
    private Map<String,HashSet<Serializable>> storage;
    private Storage(String path){
        this.storage = new HashMap<>();
        if (path != null) {
            this.path = path;
        }else{
            this.path = DEFAULT_PATH;
        }
        //Storage deserialization control.
    }

    /**
     * Returns an instance of storage attribute.
     * @return Storage
     */
    public static Storage getInstance(String path){
        if (instance == null){
            instance = new Storage(path);
        }
        instance.setPath(path);
        return instance;
    }
    public static Storage getInstance(){
        if (instance == null){
            instance = new Storage(null);
        }
        return instance;
    }

    /**
     * Returns the value associated to key param from the storage.
     * @param key key from storage map.
     * @return Set<Serializable>
     */
    public Set<Serializable> getValue(String key){
        return this.storage.get(key);
    }

    /**
     * Sets the value associated to a storage`s map key.
     * @param key key from storage map.
     * @param value value to get key associated with.
     */
    public void setValue(String key, HashSet<Serializable> value){
        this.storage.put(key,value);
    }

    /**
     * Adds a Serializable object into a HashSet related to a key.
     * @param key key from storage map.
     * @param object instance to put in the HashSet.
     */
    public void addToValue(String key, Serializable object){
        HashSet<Serializable> newSet = this.storage.get(key);
        if (newSet == null){
            newSet = new HashSet<>();
        } else{
            newSet = this.storage.get(key);
        }
        newSet.add(object);
        this.setValue(key,newSet);
    }

    /**
     * Removes an object from a HashMap associated with a key from storage.
     * @param key key from storage map.
     * @param object instance to delete from HashSet values.
     */
    public void deleteFromValue(String key,Serializable object){
        HashSet<Serializable> newSet = this.storage.get(key);
        if (newSet != null){
            newSet.remove(object);
            this.setValue(key,newSet);
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
