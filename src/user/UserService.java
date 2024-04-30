package user;

import model.User;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.util.List;

public interface UserService {

    User create (String nickName, long document, String email, String password) throws IOException;
    void read (User user);
    User update(User user, String updatedNickName, String updatedEmail, String updatedPassword) throws IOException;

    List<User> bulkCreate(List<User> users) throws IOException;

}
