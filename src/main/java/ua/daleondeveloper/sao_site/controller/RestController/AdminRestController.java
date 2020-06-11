package ua.daleondeveloper.sao_site.controller.RestController;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.GamePublication;
import ua.daleondeveloper.sao_site.domain.publication.MangaPublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.dto.AdminUserDto;
import ua.daleondeveloper.sao_site.dto.PublicationDto;
import ua.daleondeveloper.sao_site.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.AnimePublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.GamePublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.MangaPublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/admin/")
public class AdminRestController {
    private final UserService userService;
    private final PublicationService publicationService;
    private final AnimePublicationService animePublicationService;
    private final GamePublicationService gamePublicationService;
    private final MangaPublicationService mangaPublicationService;
    private final GenreService genreService;

    @Autowired
    public AdminRestController(UserService userService, PublicationService publicationService, AnimePublicationService animePublicationService, GamePublicationService gamePublicationService, MangaPublicationService mangaPublicationService, GenreService genreService) {
        this.userService = userService;
        this.publicationService = publicationService;
        this.animePublicationService = animePublicationService;
        this.gamePublicationService = gamePublicationService;
        this.mangaPublicationService = mangaPublicationService;
        this.genreService = genreService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminUserDto> getUserById(@PathVariable(name = "id") Long id) {
        System.out.println("id = [" + id + "]");
        Optional<User> user = userService.findById(id);

        if (!user.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminUserDto result = AdminUserDto.fromUser(user.get());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "publication/genre/{str}")
    public ResponseEntity getGenres(@PathVariable(name = "str")String reqTxt){
        return ResponseEntity.ok(genreService.getByTxt(reqTxt));
    }
    @PostMapping(value = "publication/{type}/add")
    public ResponseEntity<PublicationDto> addAnimePublication(PublicationDto publicationDto, @PathVariable(name = "type")String type){
        Publication publication = publicationDto.toPublication();
        switch(type.toLowerCase()){
            case("anime"):
                publication = animePublicationService.addPublication((AnimePublication)publication);
                break;
            case("manga"):
                publication = mangaPublicationService.addPublication((MangaPublication)publication);
                break;
            case("game"):
                publication = gamePublicationService.addPublication((GamePublication)publication);
                break;
        }
        return ResponseEntity.ok().body(publicationDto.fromPublication(publication));
    }
    @PostMapping(value = "publication/anime/edit/{id}")
    public ResponseEntity editAnimePublication(PublicationDto publicationDto){
        Publication requestPublication = publicationDto.toPublication();
        if(requestPublication.getId() > 0) {
            Publication updatedPublication = publicationService.merge(requestPublication);
            return ResponseEntity.ok().body(updatedPublication);
            }
            return ResponseEntity.badRequest().body(requestPublication);
        }

}
