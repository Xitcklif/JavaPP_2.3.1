package com.xitcklif.javapp.util;

import com.xitcklif.javapp.model.User;
import com.xitcklif.javapp.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DBInit {

    private final UserService userService;

    public DBInit(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void createNewUsersOnStart() {
        userService.add(new User("Andrey", "Ivanov", "ai@mail.ru", "54325"));
        userService.add(new User("Sergey", "Petrov", "sp@mail.ru", "home"));
        userService.add(new User("Vladimir", "Putin", "vp@mail.ru", "car"));
        userService.add(new User("Alexander", "Lukoshenko", "al@mail.ru", "789546"));
        userService.add(new User("Anton", "Pavlov", "ap@mail.ru", "airplane"));
    }
}
