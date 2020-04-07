package ua.daleondeveloper.sao_site.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/")
public class PublicationController {

    @RequestMapping(name = "anime/{anime_link_name}")
    public String getAnimePublication(){

        return "index";
    }

}
