import model.User;
import user.UserServiceImpl;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        UserServiceImpl service = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);

        service = new UserServiceImpl();
        scanner = new Scanner(System.in);


        List<User> users = new ArrayList<>();

        System.out.println("Digite seu nickname: ");
        String nickname = scanner.nextLine();

        System.out.println("Digite seu document: ");
        long document = Long.parseLong(scanner.nextLine());

        System.out.println("Digite seu password: ");
        String password = scanner.next();

        System.out.println("Digite seu e-mail: ");
        String email = scanner.nextLine();

        User user = service.create(nickname, document, password, email );
        service.read(user);

        System.out.println("Seus dados foram vazados, precisamos atualizar algumas informações! Por favor, digite seu nome atualizado: ");
        String updatedNickname = scanner.nextLine();

        System.out.println("Digite seu email atualizado: ");
        String updatedEmail = scanner.nextLine();

       System.out.println("Digite uma nova senha: ");
       String updatedPassword = scanner.nextLine();

        User updatedUser = service.update(user, updatedNickname, updatedEmail, updatedPassword );
        service.read(updatedUser);

        List<User> users1 = new ArrayList<>();
        users.add(user);

        service.bulkCreate(users);

        boolean isDeleted = service.delete(updatedUser);

        System.out.println(isDeleted
                ? "Usuario atualizado com sucesso"
                : "Registro não encontrado");


    }
}

