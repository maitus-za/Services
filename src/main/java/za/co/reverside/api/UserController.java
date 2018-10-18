package za.co.reverside.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import za.co.reverside.domain.User;
import za.co.reverside.repository.UserRepository;

import javax.print.attribute.standard.Media;
import java.awt.*;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/")
@Api(value = "UserControllerAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Adding User ***
    @RequestMapping(path = "addUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Create a single user.")
    public User saveUser(@RequestBody User userToSave) {
        return userRepository.save(userToSave);
    }

    // Getting All User ***
    @RequestMapping(path = "getAllUsers", method = RequestMethod.GET, produces = "text/plain")
    @ApiOperation("Read all the users.")
    public String getUser() {
        return  userRepository.findAll().toString();
    }

    // Getting A Single User ***
    @RequestMapping(path = "getUser/{id}", method = RequestMethod.GET)
    @ApiOperation("Read a single user with specific id.")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    // Updating a user ***
    @RequestMapping(path = "updateUser/{id}", method = RequestMethod.PUT)
    @ApiOperation("Updating user details.")
    public User updateUser(@RequestBody User userToUpdate) {
        return userRepository.save(userToUpdate);
    }

    // Delete a user ***
    @RequestMapping(path = "deleteUser/{id}", method = RequestMethod.DELETE)
    @ApiOperation("Delete the spefic user.")
    public String deleteUser(@PathVariable Long id) {
        User user = userRepository.getOne(id);
        userRepository.delete(user);
        return "User is deleted";
    }
}
