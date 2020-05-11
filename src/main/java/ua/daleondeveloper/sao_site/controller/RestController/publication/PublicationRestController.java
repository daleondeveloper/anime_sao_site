package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.utils.constants.FileConstants;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping(name = "/api/v1/publication/")
public class PublicationRestController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private DBFileStorageService dbFileStorageService;

    @GetMapping(value = "get_number_of_publication")
    public ResponseEntity get_number_of_publication(){

        return ResponseEntity.ok(publicationService.getCount());
    }
    @GetMapping(value = "get_publication_{start}_{end}")
    public  ResponseEntity get_publication(@PathVariable(name = "start")int start, @PathVariable(name = "end")int end){
        return ResponseEntity.ok(publicationService.getPublicationByNumber(start,end));
    }

    @PostMapping(value = "uploadAvatar/{id}")
    public ResponseEntity uploadAvatar (@RequestParam("file")MultipartFile requestFile, @PathVariable(name = "id")Long id) {

        //Check if file has image type
        if (!requestFile.getContentType().split("/")[0].equals("image")) {
            return ResponseEntity.badRequest().body("Bad image type");
        }

        if (requestFile.getSize() > FileConstants.MAX_IMAGE_SIZE) {
            return ResponseEntity.badRequest().body("Bad image size");
        }

            Optional<Publication> publication = publicationService.findById(id);
            if (publication.isPresent()) {
                try {
                    ImageAvatar imageAvatar = (ImageAvatar) dbFileStorageService.storeFile(
                            new ImageAvatar(requestFile.getName(), requestFile.getContentType(), requestFile.getBytes(), RoleEnum.ROLE_GUEST, publication.get()));

                    publicationService.updateAvatar(publication.get().getId(), imageAvatar);
                } catch (IOException e) {
                    System.out.println(e);
                }


            }


            return null;

    }

//    @GetMapping(name = "get_avatar")
//    public ResponseEntity getAvatar(){
//
//        return null;
//    }


}
