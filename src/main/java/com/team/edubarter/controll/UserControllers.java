// package com.team.edubarter.controll;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.team.edubarter.model.User;
// import com.team.edubarter.repository.UserRepository;

// @Controller
// public class UserControllers {

//     @Autowired
//     private UserRepository userRepository;
//     @GetMapping("/register")
//     public String showRegisterForm(Model model) {
//         model.addAttribute("user", new User());
//         return "register"; 
//     }

//     @PostMapping("/register")
//     public String processRegister(@ModelAttribute("user") User user, Model model) {
//         if (userRepository.findByEmail(user.getEmail()) != null) {
//             model.addAttribute("error", "Email already registered");
//             return "register"; 
//         }

//         user.setPassword(user.getPassword());

//         userRepository.save(user);

//         return "redirect:/login"; 
//     }

//     @GetMapping("/login")
//     public String showLoginForm(Model model) {
//         model.addAttribute("user", new User());
//         return "login";  
//     }

//     @PostMapping("/login")
//     public String processLogin(@ModelAttribute User user, Model model) {
//         User existing = userRepository.findByEmail(user.getEmail());
//         if (existing != null) {
//             return "redirect:user/dashboard";
//         } else {
//             model.addAttribute("error", "Invalid email or password");
//             return "login";
//         }
//     }
// }
