package pl.javastart.jjdind49_katibar_zad20_1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UsersRepo usersRepo;

    public UserController(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @PostMapping("/form")
    public String addUserWithPostMethod(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
        if (!firstName.isEmpty()) {
            createNewUser(firstName, lastName, age);
            return "redirect:/success.html";
        } else {
            return "redirect:/err.html";
        }
    }
    @RequestMapping("/users")
    @ResponseBody
    public String showUsers() {
        List<User> userList = usersRepo.getUserList();
        String result = "";
        for (User user : userList) {
            result += user.toString() + "<br/>";
        }
        return result;
    }

    @GetMapping("/add")
    public String addUserWithGetMethod(@RequestParam(value = "imie", required = false) String firstName,
                           @RequestParam("nazwisko") String lastName,
                           @RequestParam("wiek") Integer age) {
        if (firstName != null) {
            createNewUser(firstName, lastName, age);
            return "/success.html";
        } else {
            return "/err.html";
        }
    }

    private void createNewUser(String firstName, String lastName, Integer age) {
        User user = new User(firstName, lastName, age);
        usersRepo.addUser(user);
    }
}