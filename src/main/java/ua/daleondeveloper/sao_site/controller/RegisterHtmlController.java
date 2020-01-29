package ua.daleondeveloper.sao_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/jsp/")
public class RegisterHtmlController {

    @RequestMapping(value = "Reg", method = RequestMethod.GET)
    public String mymethod(Locale locale, Model model){
        System.out.println("WHAT");
        return "Registration";
    }
}
