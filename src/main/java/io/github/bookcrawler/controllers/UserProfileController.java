package io.github.bookcrawler.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class UserProfileController {

    @SessionScope
    @RequestMapping(value = "/myProfile", method = RequestMethod.GET)
    public String myProfilePage(HttpSession session, Principal principal) {
        String name = principal.getName();
        session.setAttribute("userName", name);
        return "myProfile";
    }

}
