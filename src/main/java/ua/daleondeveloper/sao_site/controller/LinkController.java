package ua.daleondeveloper.sao_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class LinkController {

    @RequestMapping(value = "registration", method = RequestMethod.GET)
    public String registrationLink(Locale locale, Model model){
        return "registration";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainLink(Locale locale, Model model){
        return "index";
    }

    @RequestMapping(value = "anime", method = RequestMethod.GET)
    public String animeLink(Locale locale, Model model){
        return "anime";
    }

    @RequestMapping(value = "manga", method = RequestMethod.GET)
    public String mangaLink(Locale locale, Model model){
        return "manga";
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
