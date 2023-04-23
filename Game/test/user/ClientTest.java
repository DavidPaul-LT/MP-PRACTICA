package user;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ClientTest {
    @Test
    void clientCorrectInstantiationTest() throws InstantiationException {
        String regNumber = "123ABC";
        String name = "Paul";
        String nick = "Paulinux";
        String validPassword = "Qwerty1234";
        User testUser = new Client(regNumber,name,nick,validPassword);
        assertEquals(name,testUser.getName());
    }
    @Test
    void clientWrongInstantiation() throws InstantiationException {
        String regNumber = "123ABC";
        String name = "Paul";
        String nick = "Paulinux";
        String validPassword = "";
        assertThrows(InstantiationException.class, () -> {
            User testUser = new Client(regNumber,name,nick,validPassword);
        });
    }
}