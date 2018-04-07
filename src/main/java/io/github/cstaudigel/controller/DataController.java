package io.github.cstaudigel.controller;

import io.github.cstaudigel.domain.models.Password;
import io.github.cstaudigel.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DataController {

    private DataService dataService;

    @Autowired
    public DataController(DataService dataService) {
        this.dataService = dataService;
    }



    @RequestMapping(value = "/createNote/")
    public String createNote() {
        return "notes";
    }

    @RequestMapping(value = "/createPassword")
    public String createPassword(@RequestParam String password,
                                 @RequestParam String admin) {
        dataService.createPassword(password, admin);

        return "home";
    }

    @RequestMapping(value = "/deletePassword/")
    public String deletePassword(@RequestParam String password,
                                 @RequestParam String admin) {
        dataService.deletePassword(password, admin);

        return "home";
    }

    @RequestMapping(value = "/deleteNote/{id}")
    public String deleteNote(@PathVariable String id,
                             @RequestParam String admin) {
        try {
            int postID = Integer.parseInt(id);

            dataService.deleteNote(postID, admin);

        } catch (NumberFormatException e) {}

        return "notes";
    }

    @RequestMapping(value = "/passwords/{admin}")
    public @ResponseBody List<Password> getPasswords(@PathVariable String admin) {
        return dataService.getPasswords(admin);
    }

    @RequestMapping(value = "/saveDB")
    public @ResponseBody boolean saveDatabase() {
        return dataService.saveDatabase();
    }
}
