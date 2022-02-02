package com.xitcklif.javapp.controller;

import com.xitcklif.javapp.model.User;
import com.xitcklif.javapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.userById(id));
        return "users/userPage";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@ModelAttribute("user") User user) {

        userService.update(user);
        return "redirect:/user/" + user.getId();
    }

    @PostMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.rmUserById(id);
        return "redirect:/";
    }
}
