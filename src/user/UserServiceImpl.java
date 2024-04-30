package user;

import model.User;
import sun.security.util.Password;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class UserServiceImpl implements UserService  {

    private List<User> userList;

    public UserServiceImpl() {
        this.userList = new ArrayList<>();
    }

    @Override
    public User create(String nickName, long document, String email, String password) throws IOException {
        if (email.contains("@")) {
            User user = new User();
            user.setNickName(nickName);
            user.setDocument(document);
            user.setPassword(password);
            user.setEmail(email);
            gerarBanco(user, "gerando_banco_dados");
            return user;
        }
        return new User();
    }

    @Override
    public void read(User user) {
        System.out.println(user);
    }

    @Override
    public User update(User user, String updatedNickName, String updatedEmail, String updatedPassword) throws IOException {
        user.setNickName(updatedNickName);
        user.setEmail(updatedEmail);
        user.setPassword(updatedPassword);
        gerarBanco(user, "atualizando_banco_dados");
        return user;

    }

    @Override
    public List<User> bulkCreate(List<User> users) throws IOException {
        for (User user : users)  {
            userList.add(user);
            gerarBanco(user, "usuarios_cadastrados");
        }
        return userList;
    }

    public boolean delete(User user) {
        if (null != user) {
            user = new User();
            return true;
        }
        return false;
    }

    private void gerarBanco(User users, String nomeBanco) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(nomeBanco + ".txt", true));
        writer.write(users.toString() + "\n");
        writer.close();
    }

}


