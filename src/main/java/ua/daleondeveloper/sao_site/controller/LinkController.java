package ua.daleondeveloper.sao_site.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.persistence.Access;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class LinkController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registrationLink(Locale locale, Model model){
        return "registration";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainLink(Locale locale, Model model){
        return "index";
    }

    @RequestMapping(value = "anime", method = RequestMethod.GET)
    public String animeLink(HttpServletRequest request, Locale locale, Model model){
        return "anime";
    }

    @RequestMapping(value = "manga", method = RequestMethod.GET)
    public String mangaLink(Locale locale, Model model){
        return "manga";
    }

    @RequestMapping(value = "admin", method = RequestMethod.GET)
    public String adminLink(Locale locale, Model model){
        return "admin";
    }

    @RequestMapping(value = "game", method = RequestMethod.GET)
    public String gameLink(Locale locale, Model model){
        return "game";
    }

    @RequestMapping(value = "contacts", method = RequestMethod.GET)
    public String contactsLink(Locale locale, Model model){
        return "contacts";
    }
}
