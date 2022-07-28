package io.decid.emailservicesendgrid.controllers;

import io.decid.emailservicesendgrid.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping(path = "/")
    public String index() {
        return "home";
    }

    @PostMapping(path = "/register")
    public String userRegistration(@ModelAttribute User user, Model model) {
        System.out.println(user.toString());
        // validate
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        String name = String.valueOf(model.addAttribute("name", user.getName()));
        String emailTo = String.valueOf(model.addAttribute("email", user.getEmail()));

        return "home";
    }

}
