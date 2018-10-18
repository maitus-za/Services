package za.co.reverside.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.co.reverside.domain.Message;
import za.co.reverside.repository.MessageRepository;

import java.util.Date;

@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @RequestMapping(path = "api/status", method = RequestMethod.GET, produces = "text/plain")
    public String getStatus(){
        return "OK [" + new Date() + "]";
    }

    @RequestMapping(path = "api/messages", method = RequestMethod.POST, consumes = "text/plain")
    public void createMessage(@RequestBody String text){
        Message message = new Message();
        messageRepository.save(message);
    }
}
