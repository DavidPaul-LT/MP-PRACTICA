package storage;

import static org.junit.jupiter.api.Assertions.*;

import equipment.Armor;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.ArrayList;

class StorageTest {
    @Test
    void notNullInstantiationTest(){
        Storage.reset();
        assertNotNull(Storage.getInstance());
    }
    @Test
    void singletonTest(){
        Storage.reset();
        Storage testStorage1 = Storage.getInstance();
        Storage testStorage2 = Storage.getInstance();
        assertEquals(testStorage1, testStorage2);
    }
    @Test
    void singletonTest2(){
        Storage.reset();
        Storage testStorage1 = Storage.getInstance();
        Storage.reset();
        Storage testStorage2 = Storage.getInstance();
        assertNotEquals(testStorage1,testStorage2);
    }
    @Test
    void setValueTest(){
        Storage.reset();
        Storage testStorage = Storage.getInstance();
        String testKey = "randomKey";
        Serializable testObject = new Armor();
        testStorage.setValue(testKey,testObject);
        assertNotNull(testStorage.getValue(testKey));
    }
    @Test
    void deleteElementsTest(){
        Storage.reset();
        Storage testStorage = Storage.getInstance();
        String testKey = "Armors";
        int K = 5;
        ArrayList<Serializable> testArmorArray = new ArrayList<>();
        testStorage.setValue(testKey, testArmorArray);
        for (int i=0;i < K; i++){
            ArrayList<Serializable> auxPointer = (ArrayList<Serializable>) testStorage.getValue(testKey);
            auxPointer.add(new Armor());
        }
        ArrayList<Serializable> auxPointer = (ArrayList<Serializable>) testStorage.getValue(testKey);
        auxPointer.remove(0);
        assertEquals(K-1,((ArrayList<?>) testStorage.getValue(testKey)).size());
    }
    @Test
    void deleteKeyTest(){
        Storage.reset();
        Storage testStorage = Storage.getInstance();
        String testKey = "RandomKey";
        testStorage.setValue(testKey,new Armor());
        testStorage.deleteKey(testKey);
        assertNull(testStorage.getValue(testKey));
    }
    @Test
    void safeSerializationTest(){
        Storage.reset();
        Storage testStorage = Storage.getInstance();
        String testKey = "RandomKey";
        ArrayList<Armor> armorSet = new ArrayList<>();
        armorSet.add(new Armor());
        testStorage.setValue(testKey,armorSet);
        armorSet.add(new Armor());
        Storage testStorage2 = Storage.getInstance();
        ArrayList<Armor> armors = (ArrayList<Armor>) testStorage2.getValue(testKey);
        assertEquals(2,armors.size());
    }
}