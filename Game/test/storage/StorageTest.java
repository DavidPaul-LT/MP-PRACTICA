package storage;

import static org.junit.jupiter.api.Assertions.*;

import minion.Ghoul;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Set;

class StorageTest {

    @Test
    void notNullInstantiationTest(){
        assertNotNull(Storage.getInstance());
    }
    @Test
    void singletonImplementationTest(){
        Storage testStorage = Storage.getInstance();
        assertEquals(testStorage,Storage.getInstance());
    }
    @Test
    void singletonImplementationTest2(){
        Storage testStorage = Storage.getInstance();
        assertEquals(testStorage,Storage.getInstance());
    }
    @Test
    void addToValueTest(){
        Storage testStorage = Storage.getInstance();
        String testKey = "AnyRandomKey";
        Serializable testObject = null;
        testStorage.addToValue(testKey,testObject);
        assertTrue(testStorage.getValue(testKey).contains(testObject));
    }
    @Test
    void allValuesDeletion(){
        int randomLength = (int) (Math.random() * 10);
        Storage testStorage = Storage.getInstance();
        String testKey = "Minion List";
        for (int e=0;e<randomLength;e++){
            testStorage.addToValue(testKey, new Ghoul("Bob"));
        }
        assertEquals(testStorage.getValue(testKey).size(),randomLength);
        testStorage.deleteKey(testKey);
        assertNull(testStorage.getValue(testKey));
    }
    @Test
    void serializationTest(){
        Storage testStorage = Storage.getInstance();
        String testKey = "RandomKeyValue";
        testStorage.addToValue(testKey,null);
        testStorage.serialize();
        Storage testStorage2 = Storage.deserialize();
        assertEquals(testStorage.getValue(testKey),testStorage2.getValue(testKey));
        assertNotNull(testStorage.getValue(testKey));
        assertNotNull(testStorage2.getValue(testKey));
    }
}