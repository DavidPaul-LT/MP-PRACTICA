package storage;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storage implements Serializable{
    private static final String DEFAULT_PATH = "game_files" + File.separator + "storage.txt";
    private static Storage instance;
    private Map<String,HashSet<Serializable>> storage;
    private Storage(){
        this.storage = new HashMap<>();
    }

    /**
     * Serializes the Storage instance.
     */
    public void serialize(){
        try {
            File file = new File(Storage.DEFAULT_PATH);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(Storage.instance);
            oos.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Deserializes the Storage instance.
     * @return Storage
     */
    public static Storage deserialize(){
        try {
            FileInputStream file = new FileInputStream(Storage.DEFAULT_PATH);
            ObjectInputStream fileAux = new ObjectInputStream(file);
            Storage auxStorage = (Storage) fileAux.readObject();
            file.close();
            fileAux.close();
            return auxStorage;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
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

    /**
     * Deletes the Set associated to a specific key.
     * @param key Key from storage map.
     */
    public void deleteKey(String key){
        this.setValue(key,null);
    }
}
