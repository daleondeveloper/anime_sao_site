package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.dto.AnimePublicationDto;
import ua.daleondeveloper.sao_site.dto.PublicationDto;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.ImageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.AnimePublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.CategoriesService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;
import ua.daleondeveloper.sao_site.utils.FileCheker;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.*;
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
    private GenreService genreService;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ImageService imageService;

    @GetMapping("getCount")
    public ResponseEntity getNumberOfAnime(){

        return ResponseEntity.ok().body(animePublicationService.getCount());
//        return ResponseEntity.ok().body(userService.getCount());
    }
    //При зміні showCount також потрібно змінити значення у resources/static/js/publication/animePublication.js
    //у методі createNumericalPageNavigation зміну publicationInPage на такеж значення
    @GetMapping(value = "getAnime/{page}")
    public  ResponseEntity getPublication(@PathVariable(name = "page")int page){
        int showCount = 10;
        return ResponseEntity.ok(animePublicationService.getAnimeByNumber(page,showCount));
    }
    @GetMapping(value = "publication/genre/{str}")
    public ResponseEntity getGenres(@PathVariable(name = "str")String reqTxt){
        return ResponseEntity.ok(genreService.getByTxt(reqTxt));
    }

    @GetMapping(value = "getInfoImagesId/{id}")
    public ResponseEntity<Object> getInfoImagesId(@PathVariable("id")Long id){

        List<ImagePublication> images = animePublicationService.getInfoImages(id);
        List<Long> resEntList = new ArrayList<>();
        for(ImagePublication imagePublication : images){
            resEntList.add(imagePublication.getId());
        }
        return ResponseEntity.ok(resEntList);
    }
    @GetMapping(value = "getInfoImage/{id}")
    public ResponseEntity<Object> getInfoImage(@PathVariable("id")Long imageId,HttpServletRequest request){
        ImagePublication image = (ImagePublication)dbFileStorageService.getFile(imageId,null);
        if(image == null){
            return ResponseEntity.badRequest().body("Id is invalid");
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + image.getFileName() + "\"")
                .body(Base64.getEncoder().encode(image.getData()));
    }

    @PostMapping(value = "admin/add")
    public ResponseEntity addPublication( AnimePublicationDto animePublicationDto, HttpServletRequest request){
        AnimePublication publication = animePublicationService.addPublication(animePublicationDto.toAnimePublication(genreService,categoriesService));
        return ResponseEntity.ok(publication);
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

              //  animePublicationService.addInfoImage(publication.get().getId(), imageInfo);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage() + " FileName: " + file.getName());
        }
        return ResponseEntity.ok().body("Image download: " +  file.getName());

    }

}
