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

    @Autowired
    public AdminRestController(UserService userService, PublicationService publicationService, AnimePublicationService animePublicationService, GamePublicationService gamePublicationService, MangaPublicationService mangaPublicationService) {
        this.userService = userService;
        this.publicationService = publicationService;
        this.animePublicationService = animePublicationService;
        this.gamePublicationService = gamePublicationService;
        this.mangaPublicationService = mangaPublicationService;
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
    @PostMapping(value = "publication/anime/add")
    public ResponseEntity<PublicationDto> addAnimePublication(PublicationDto publicationDto){
        Publication publication = publicationDto.toPublication();
        publication = animePublicationService.addPublication((AnimePublication)publication);
        return ResponseEntity.ok().body(publicationDto.fromPublication(publication));
    }
    @PostMapping(value = "publication/anime/edit/{id}")
    public ResponseEntity.BodyBuilder editAnimePublication(PublicationDto publicationDto){
        Publication requestPublication = publicationDto.toPublication();
        if(requestPublication.getId() > 0) {
            Optional<Publication> publicationBDOptional = publicationService.findById(requestPublication.getId());
            if (publicationBDOptional.isPresent()) {
                AnimePublication publicationBD = (AnimePublication)publicationBDOptional.get();
                if(requestPublication.getDescription() != null)
                publicationBD.setDescription(requestPublication.getDescription());
                if(requestPublication.getFullName() != null)
                publicationBD.setFullName(requestPublication.getFullName());
                if(requestPublication.getName() != null)
                publicationBD.setName(requestPublication.getName());
                if(requestPublication.getDirector() != null)
                publicationBD.setDirector(requestPublication.getDirector());
                if(requestPublication.getLanguage() != null)
                publicationBD.setLanguage(requestPublication.getLanguage());
                if(requestPublication.getGenre() != null)
                publicationBD.setGenre(requestPublication.getGenre());
                if(requestPublication.getCategories() != null)
                publicationBD.setCategories(requestPublication.getCategories());
                if(requestPublication.getPostInfoShort() != null)
                publicationBD.setPostInfoShort(requestPublication.getPostInfoShort());
//                if(requestPublication.getGroup() != null)
//                publicationBD.setGroup(requestPublication.getGroup());
                publicationBD.setLastUpdateDate(LocalDate.now());
                publicationBD.setLastUpdateTime(LocalTime.now());
                //заміна даних
            }
        }
            return ResponseEntity.badRequest();

        }
}
