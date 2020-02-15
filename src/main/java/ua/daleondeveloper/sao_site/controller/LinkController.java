package ua.daleondeveloper.sao_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class LinkController {

    @RequestMapping(value = "Registration", method = RequestMethod.GET)
    public String registrationLink(Locale locale, Model model){
        return "Registration";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String mainLink(Locale locale, Model model){
        return "index";
    }
}
