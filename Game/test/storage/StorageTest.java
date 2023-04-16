package storage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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

}