package com.team.edubarter.controll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String root() {
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String home() {
        return "home"; // home.html
    }

    @RequestMapping("/about")
    public String about(Model model) {
        return "about"; // about.html
    }

    @GetMapping("/services")
    public String services() {
        return "services"; // services.html
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact"; // contact.html
    }
}
