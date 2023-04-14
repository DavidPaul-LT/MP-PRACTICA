package storage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storage {
    private static Storage instance;
    private Map<String,HashSet<Serializable>> storage;
    private Storage(){
        this.storage = new HashMap<>();
    }

    /**
     * Returns an instance of storage attribute.
     * @return Storage
     */
    public static Storage getInstance(){
        if (instance == null){
            instance = new Storage();
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
}
