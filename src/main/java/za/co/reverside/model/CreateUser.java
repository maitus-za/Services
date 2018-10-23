package za.co.reverside.model;


import lombok.Data;
import za.co.reverside.domain.User;

@Data
public class CreateUser {

    private String firstName;

    private String lastName;

    private String department;

    private String cellNumber;

    private String emailAddress;

    private String password;

    public User map(User user){

        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setDepartment(this.department);
        user.setCellNumber(this.cellNumber);
        user.setEmailAddress(this.emailAddress);
        user.setPassword(this.password);

        return user;
    }
}
