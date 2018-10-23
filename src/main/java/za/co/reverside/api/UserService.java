package za.co.reverside.api;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.domain.User;
import za.co.reverside.model.CreateUser;
import za.co.reverside.model.UpdateUser;
import za.co.reverside.model.UserDetail;
import za.co.reverside.model.UserInfo;
import za.co.reverside.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(path = "api/users", method = RequestMethod.POST, consumes = "application/json")
    @ApiOperation("Create")
    public void create(@RequestBody CreateUser command) {
        log.info("Create user - command: {} ", command);
        User user = command.map(new User());
        userRepository.save(user);
        log.info("User Created- id: {} ", user.getId());
    }

    @RequestMapping(path = "api/users/{id}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Read")
    public UserDetail retrieve(@PathVariable("id") Long id){
        log.info("Retrieve User - id: {}", id);
        User user =  userRepository.getOne(id);
        if(user == null){
            log.warn("User Not Found - id: {}", id);
            throw  new RuntimeException("User Not Found");
        }
        log.info("User Retrieved - user: {}", user);
        return new UserDetail(user);
    }

    @RequestMapping(path = "api/users", method = RequestMethod.GET)
    @ApiOperation("Read")
    public List<UserInfo> search(){
        log.info("Search Users");
        List<UserInfo>  list = new ArrayList<UserInfo>();
        List<User> users = userRepository.findAll();
        for(User user : users){
            list.add(new UserInfo(user));
        }
        log.info("Users Found -  total: {}", list.size());
        return list;
    }


    @RequestMapping(path =  "api/users/{id}", method = RequestMethod.PUT, consumes = "application/json")
    @ApiOperation("Update")
    public void update(@PathVariable("id") Long id, @RequestBody UpdateUser command){
        log.info("Update User - id: {}, command:{}", id, command);
        User user =  userRepository.getOne(id);
        if(user == null){
            log.warn("User Not Found - id: {}", id);
            throw new RuntimeException("User Not Found");
        }
        user = command.map(user);
        userRepository.save(user);
        log.info("User Updated - id: {}", id);
    }

    @RequestMapping(path = "api/users/{id}", method = RequestMethod.DELETE)
    @ApiOperation("Delete")
    public void delete(@PathVariable("id") Long id){
        log.info("Delete User - id: {}", id);
        User user =  userRepository.getOne(id);
        if(user == null){
            log.warn("User Not Found - id: {}", id);
            throw new RuntimeException("User Not Found");
        }
        userRepository.delete(user);
        log.info("User Deleted - id: {}", id);
    }
}
