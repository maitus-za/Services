package za.co.reverside.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.reverside.domain.User;

@Data
public class UserDetail {

    public Long id;

    private String firstName;

    private String lastName;

    private String department;

    private String cellNumber;

    private String emailAddress;

    public UserDetail(User user){

        this.id = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.department = user.getDepartment();
        this.cellNumber = user.getCellNumber();
        this.emailAddress = user.getEmailAddress();
    }

}
