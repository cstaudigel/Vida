package io.github.cstaudigel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping(value = {"/", "/Home"})
    public String goHome() {
        return "home";
    }

    @RequestMapping(value = "/Ministry")
    public String ministry() {
        return "ministry";
    }

    @RequestMapping(value = "/Contact")
    public String contactUs() {
        return "contact";
    }

    @RequestMapping(value = "/Notes")
    public String parishNotes() {
        return "notes";
    }

    @RequestMapping(value = "/Rights")
    public String rights() {
        return "rights";
    }
}
