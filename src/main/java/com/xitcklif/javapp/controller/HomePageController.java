package com.xitcklif.javapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(value = "/")
    public String openHomePage() {
        return "homePage";
    }
}
