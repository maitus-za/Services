package za.co.reverside.api;

import org.junit.Test;

import static org.junit.Assert.*;


public class MessageControllerTest {

    @Test
    public void testStatus(){
        MessageController messageController = new MessageController();
        String result = messageController.getStatus();
        assertTrue(result.startsWith("OK ["));
    }
}