package io.github.cstaudigel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NavigationController {

    @RequestMapping(value = {"/", "/home"})
    public String goHome() {
        return "home";
    }

    @RequestMapping(value = "/About")
    public String aboutUs() {
        return "about";
    }

    @RequestMapping(value = "/Contact")
    public String contactUs() {
        return "contact";
    }

    @RequestMapping(value = "/Notes")
    public String parishNotes() {
        return "notes";
    }
}
