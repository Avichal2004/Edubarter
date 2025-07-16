package com.team.edubarter.controll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.team.edubarter.model.User;
import com.team.edubarter.repository.UserRepository;

@Controller
public class UserControllers {

    @Autowired
    private UserRepository userRepository;

    // private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // return register.html
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User user, Model model) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("error", "Email already registered");
            return "redirect:user/dashboard";  // Show register form again
        }

        // Encode password before saving
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        return "login";  // Redirect to login after successful registration
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";  // return login.html
    }

    @PostMapping("/login")
    public String processLogin(@ModelAttribute User user, Model model) {
        User existing = userRepository.findByEmail(user.getEmail());
        if (existing != null) {
            // TODO: Set session or security context if you add authentication later
            return "redirect:user/dashboard";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
