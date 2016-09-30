package io.github.bookcrawler.controllers;

import io.github.bookcrawler.entities.RobotUser;
import io.github.bookcrawler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegistrationAndLoginController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/register")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new RobotUser());
        return "registration";
    }

    @PostMapping(value = "/register")
    public String register(@ModelAttribute("user") @Valid RobotUser user, BindingResult result,Errors errors) {
        if (!result.hasErrors()) {
            userRepository.save(user);
        }
        return "index";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,
                                  @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid Credentials provided.");
        }

        if (logout != null) {
            model.addObject("message", "Logged out from JournalDEV successfully.");
        }

        model.setViewName("loginPage");
        return model;
    }

}
