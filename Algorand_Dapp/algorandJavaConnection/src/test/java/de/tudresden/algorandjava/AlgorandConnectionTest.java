package de.tudresden.algorandjava;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class AlgorandConnectionTest {
    @Test 
    void creepyTest() {
        Assertions.assertEquals("hello world", "hello world");
    }

    @Test
    void addTwoNumberTest() {
        Assertions.assertEquals((2+2), 4);
    }

    @Test
    void testAlgorandConnection() throws Exception {
        AlgorandConnection app = new AlgorandConnection();
        //Account newAccount = app.createAccount();
        //newAccount.gettingStartedExample(newAccount);
        Assertions.assertNotNull(app.createAccount());
    }
}
