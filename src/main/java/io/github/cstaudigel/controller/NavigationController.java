package io.github.cstaudigel.controller;

import io.github.cstaudigel.domain.viewmodels.InvolvementViewModel;
import io.github.cstaudigel.domain.viewmodels.NotesViewModel;
import io.github.cstaudigel.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

    private DataService dataService;

    @Autowired
    public NavigationController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping(value = {"/", "/Home"})
    public String goHome() {
        return "home";
    }

    @GetMapping(value = "/Ministry")
    public String ministry() {
        return "ministry";
    }

    @GetMapping(value = "/Contact")
    public String contactUs() {
        return "contact";
    }

    @GetMapping(value = "/Notes")
    public ModelAndView parishNotes() {
        ModelAndView model = new ModelAndView("notes");
        model.addObject("model", new NotesViewModel(dataService.getAllNotes()));

        return model;
    }

    @GetMapping(value = "/Rights")
    public String rights() {
        return "rights";
    }

    @GetMapping(value = "/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping(value = "/admin/GetInvolved/{admin}")
    public ModelAndView getInvolvedAdminPage(@PathVariable String admin) {
        ModelAndView model = new ModelAndView("adminInvolved");
        model.addObject("model", new InvolvementViewModel(dataService.getAllGetInvolved(admin)));

        return model;
    }

    @GetMapping(value = "/admin/NewNote")
    public String newNoteAdminPage() {
        return "newNoteAdmin";
    }

    @GetMapping(value = "/admin/ManageNotes")
    public ModelAndView manageNotesAdmin() {
        ModelAndView model = new ModelAndView("manageNotesAdmin");
        model.addObject("model", new NotesViewModel(dataService.getAllNotes()));

        return model;
    }
}
