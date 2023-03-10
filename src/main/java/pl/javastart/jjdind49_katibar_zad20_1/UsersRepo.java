package pl.javastart.jjdind49_katibar_zad20_1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsersRepo {

    private final List<User> userList = new ArrayList<>();

    public UsersRepo() {
        userList.add(new User("Artur","Nowak", 20));
        userList.add(new User("Anna", "Wesołowska", 54));
        userList.add(new User("Wronika", "Bauer", 28));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
