package io.github.cstaudigel.controller;

import io.github.cstaudigel.domain.models.Password;
import io.github.cstaudigel.domain.viewmodels.InvolvmentViewModel;
import io.github.cstaudigel.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value ="/GetInvolved/New", method = RequestMethod.POST)
    public String newGetInvolvedRequest(@RequestParam("name") String name,
                                        @RequestParam("email") String email,
                                        @RequestParam("phone") String phone,
                                        @RequestParam("message") String message) {

        dataService.createInvolvementRequest(name, email, phone, message);

        return "home";
    }

    @RequestMapping(value = "/GetInvolved/View/{admin}")
    public @ResponseBody InvolvmentViewModel viewAllGetInvolved(@PathVariable String admin) {
        return new InvolvmentViewModel(dataService.getAllGetInvolved(admin));
    }
}
