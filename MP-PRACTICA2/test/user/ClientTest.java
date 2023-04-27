package user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import storage.Storage;

import java.util.HashMap;

class ClientTest {
    @Test
    void clientCorrectInstantiationTest() throws InstantiationException {
        String regNumber = "123ABC";
        String name = "Paul";
        String nick = "Pablimux";
        String validPassword = "Qwerty1234";
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.setRegNumber(regNumber);
        clientBuilder.setName(name);
        clientBuilder.setNick(nick);
        clientBuilder.setPassword(validPassword);
        User testUser = clientBuilder.build();
        assertEquals(name,testUser.getName());
    }
    @Test
    void clientWrongInstantiation() throws InstantiationException {
        String regNumber = "123ABC";
        String name = "Paul";
        String nick = "Paulinux";
        String validPassword = "";
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.setRegNumber(regNumber);
        clientBuilder.setName(name);
        clientBuilder.setNick(nick);
        clientBuilder.setPassword(validPassword);
        assertThrows(InstantiationException.class, () -> {
            User testUser = clientBuilder.build();
        });
    }
    @Test
    void successfulBattleRequestSendTest() throws InstantiationException {
        Storage.reset();
        Storage testStorage = Storage.getInstance();
        // User 1
        ClientBuilder clientBuilder = new ClientBuilder();
        clientBuilder.setNick("AlfonsoTamales");
        clientBuilder.setGold(2700);
        clientBuilder.setPassword("123456789");
        // User 2
        ClientBuilder clientBuilder2 = new ClientBuilder();
        clientBuilder2.setName("AlfonsoPerales");
        clientBuilder2.setGold(2700);
        clientBuilder2.setPassword("123456789");
        HashMap<String,Client> clientHashMap = new HashMap<>();
        clientHashMap.put("AlfonsoPerales", (Client) clientBuilder2.build());
        HashMap<String,Object> auxMap = new HashMap<>();
        auxMap.put("Clients",clientHashMap);
        testStorage.setValue("Users",auxMap);
        Client testClient = (Client) clientBuilder.build();
        assertTrue(testClient.sendBattleRequest("AlfonsoPerales",100));
    }
}
