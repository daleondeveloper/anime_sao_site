package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.dto.PublicationDto;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.ImageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.AnimePublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.utils.FileCheker;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/publication/anime/")
public class AnimePublicationRestController {

    @Autowired
    private AnimePublicationService animePublicationService;
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private DBFileStorageService dbFileStorageService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ImageService imageService;

    @GetMapping("getCount")
    public ResponseEntity getNumberOfAnime(){

        return ResponseEntity.ok().body(animePublicationService.getCount());
//        return ResponseEntity.ok().body(userService.getCount());
    }
    @GetMapping(value = "getAnime{page}")
    public  ResponseEntity getPublication(@PathVariable(name = "page")int page){
        return ResponseEntity.ok(animePublicationService.getAnimeByNumber(page,page+3));
    }

    @PostMapping(value = "uploadInfoImages/{id}")
    public List<ResponseEntity> uploadInfoImages(@RequestParam("files")MultipartFile[] files, @PathVariable(name = "id")Long id){
        return Arrays.asList(files).
                stream().
                map(file -> uploadInfoImage(file,id)).
                collect(Collectors.toList());
    }
    @PostMapping(value = "uploadInfoImage/{id}")
    public ResponseEntity uploadInfoImage(@RequestParam("file") MultipartFile file, @PathVariable(name = "id")Long id){
        Optional<Publication> publication = publicationService.findById(id);
        try {
            if (publication.isPresent() && FileCheker.chekImageFile(file)) {

                ImagePublication imageInfo = (ImagePublication) dbFileStorageService.storeFile(
                        new ImagePublication(file.getName(), file.getContentType(), file.getBytes(), RoleEnum.ROLE_GUEST, (AnimePublication)publication.get()));

                animePublicationService.addInfoImage(publication.get().getId(), imageInfo);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage() + " FileName: " + file.getName());
        }
        return ResponseEntity.ok().body("Image download: " +  file.getName());

    }

}
