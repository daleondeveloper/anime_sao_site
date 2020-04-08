package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.AnimePublicationService;

@RestController
@RequestMapping(name = "/api/v1/publication/anime/")
public class AnimePublicationRestController {

    @Autowired
    private AnimePublicationService animePublicationService;
    @Autowired
    private DBFileStorageService dbFileStorageService;

    @GetMapping(value = "get_number_of_publication")
    public ResponseEntity get_number_of_anime(){

        return ResponseEntity.ok(animePublicationService.getCount());
    }
    @GetMapping(value = "get_anime_{start}_{end}")
    public  ResponseEntity get_publication(@PathVariable(name = "start")int start, @PathVariable(name = "end")int end){
        return ResponseEntity.ok(animePublicationService.getAnimeByNumber(start,end));
    }

    @PostMapping(name = "create")
    public ResponseEntity createAnimePublication(){


        return null;
    }
}
