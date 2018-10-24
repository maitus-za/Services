package za.co.reverside.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import za.co.reverside.domain.User;

@Data
public class UserInfo {

    private Long id;

    private String name;

    private String cell;

    private String email;

    private String department;

    public UserInfo(User user){

        this.id = user.getId();
        this.name = user.getFirstName() + " " + user.getLastName();
        this.cell = user.getCellNumber();
        this.email = user.getEmailAddress();
        this.department = user.getDepartment();

    }

}
