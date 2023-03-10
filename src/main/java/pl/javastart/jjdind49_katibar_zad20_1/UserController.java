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

    @RequestMapping(value = "/add", method = {RequestMethod.POST, RequestMethod.GET})
    public String addUser(@RequestParam (value = "imie", required = false) String firstName,
                                        @RequestParam (value = "nazwisko", required = false) String lastName,
                                        @RequestParam (value = "wiek", required = false) Integer age) {

        if (firstName == null) {
            return "redirect:/err.html";
        } else {
            createNewUser(firstName, lastName, age);
            return "redirect:/success.html";
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


    private void createNewUser(String firstName, String lastName, Integer age) {
        User user = new User(firstName, lastName, age);
        usersRepo.addUser(user);
    }
}