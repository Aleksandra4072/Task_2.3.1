package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String allUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @RequestMapping("/addUser")
    public String addUserForm(User user) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("removeUser/{id}")
    public String removeUser(@PathVariable("id")long id) {
        userService.removeUser(id);

        return "redirect:/";
    }

    @RequestMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id")long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(User user) {
        userService.editUser(user);

        return "redirect:/";
    }
}
