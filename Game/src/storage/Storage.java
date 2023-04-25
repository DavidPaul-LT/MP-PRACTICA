package storage;

import interfaces.Resetable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Storage implements Serializable, Resetable {
    private static final String DEFAULT_PATH = "game_files" + File.separator + ".storage";
    private static Storage instance;
    private Map<String, Serializable> storageMap;
    private Storage(){
        this.storageMap = new HashMap<>();
    }

    /**
     * Serializes the Storage instance.
     */
    private Boolean serialize(){
        try {
            File file = new File(Storage.DEFAULT_PATH);
            if (!file.exists() && (file.getParentFile().mkdirs())){
                    return file.createNewFile();
            }
            try (FileOutputStream fos = new FileOutputStream(file)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(Storage.instance);
                oos.close();
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Deserializes the Storage instance.
     * @return Storage
     */
    private static Storage deserialize(){
        try {
            ObjectInputStream fileAux;
            Storage auxStorage;
            try (FileInputStream file = new FileInputStream(Storage.DEFAULT_PATH)) {
                fileAux = new ObjectInputStream(file);
                auxStorage = (Storage) fileAux.readObject();
            }
            fileAux.close();
            return auxStorage;
        } catch (IOException | ClassNotFoundException e) {
            return new Storage();
        }
    }

    /**
     * Returns an instance of storage attribute.
     * @return Storage
     */
    public static Storage getInstance(){
        if (instance == null){
            instance = Storage.deserialize();
        }
        return instance;
    }
    public static void reset(){
        instance = null;
    }
    /**
     * Returns the value associated to key param from the storage.
     * @param key key from storage map.
     * @return Set<Serializable>
     */
    public Object getValue(String key){
        return this.storageMap.get(key);
    }

    /**
     * Sets the value associated to a storage`s map key.
     * @param key key from storage map.
     * @param value value to get key associated with.
     */
    public void setValue(String key, Serializable value){
        this.storageMap.put(key, value);
        this.serialize();
    }

    /**
     * Deletes the Set associated to a specific key.
     * @param key Key from storage map.
     */
    public void deleteKey(String key){
        this.storageMap.remove(key);
        this.serialize();
    }
    public void clear(){
        this.storageMap.clear();
    }
}
