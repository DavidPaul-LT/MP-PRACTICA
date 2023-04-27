package user;

import org.junit.jupiter.api.Test;
import storage.Storage;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ClientBuilderTest {
    @Test
    void userCreationTest() throws InstantiationException {
        // User 1
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.setName("Alfonso");
        clientBuilder.setGold(2700);
        clientBuilder.setPassword("123456789");
        assertNotNull(clientBuilder.build());
    }

}