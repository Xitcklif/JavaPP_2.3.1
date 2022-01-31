package com.xitcklif.javapp.controller;

import com.xitcklif.javapp.model.User;
import com.xitcklif.javapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserPageController {

    private final UserService userService;

    @Autowired
    public UserPageController(UserService userService) {
        this.userService = userService;
        userService.add(new User("Andrey", "Ivanov", "ai@mail.ru", "54325"));
        userService.add(new User("Sergey", "Petrov", "sp@mail.ru", "home"));
        userService.add(new User("Vladimir", "Putin", "vp@mail.ru", "car"));
        userService.add(new User("Alexander", "Lukoshenko", "al@mail.ru", "789546"));
        userService.add(new User("Anton", "Pavlov", "ap@mail.ru", "airplane"));
    }

    @GetMapping()
    public String openUserPage(Model model) {
        model.addAttribute("users", userService.listUsers());
        return "users/usersPage";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.userById(id));
        return "users/userPage";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("user", new User());
        return "users/createPage";
    }

    @PostMapping()
    public String newUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") long id,
                             @ModelAttribute("user") User user) {

        userService.update(id, user);
        return "redirect:/users";
    }

    @PostMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.rmUserById(id);
        return "redirect:/users";
    }
}
