package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;

@RestController
@RequestMapping(name = "/api/v1/publication/")
public class PublicationRestController {

    @Autowired
    private PublicationService publicationService;

//    @GetMapping(value = "get_number_of_publication")
//    public ResponseEntity get_number_of_publication(){
//
//        return ResponseEntity.ok(publicationService.getCountPublication());
//    }
    @GetMapping(value = "get_publication_{start}_{end}")
    public  ResponseEntity get_publication(@PathVariable(name = "start")int start, @PathVariable(name = "end")int end){
        return ResponseEntity.ok(publicationService.getPublicationByNumber(start,end));
    }

//    @GetMapping(name = "get_avatar")
//    public ResponseEntity getAvatar(){
//
//        return null;
//    }


}
