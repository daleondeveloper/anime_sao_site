package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.dto.UploadFileResponseDto;
import ua.daleondeveloper.sao_site.exception.BadFileTypeException;
import ua.daleondeveloper.sao_site.exception.FileToBigException;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.utils.FileCheker;
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

    @GetMapping(value = "getNumberOfPublication")
    public ResponseEntity get_number_of_publication(){

        return ResponseEntity.ok(publicationService.getCount());
    }
    @GetMapping(value = "get_publication_{start}_{end}")
    public  ResponseEntity get_publication(@PathVariable(name = "start")int start, @PathVariable(name = "end")int end){
        return ResponseEntity.ok(publicationService.getPublicationByNumber(start,end));
    }

    @PostMapping(value = "uploadAvatar/{id}")
    public ResponseEntity uploadAvatar (@RequestParam("file")MultipartFile requestFile, @PathVariable(name = "id")Long id) {

            Optional<Publication> publication = publicationService.findById(id);
            try {
                if (publication.isPresent() && FileCheker.chekImageFile(requestFile)) {

                    ImageAvatar imageAvatar = (ImageAvatar) dbFileStorageService.storeFile(
                            new ImageAvatar(requestFile.getName(), requestFile.getContentType(), requestFile.getBytes(), RoleEnum.ROLE_GUEST, publication.get()));

                    publicationService.updateAvatar(publication.get().getId(), imageAvatar);
                }
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        return ResponseEntity.ok().body("Image download");
    }

//    @GetMapping(name = "get_avatar")
//    public ResponseEntity getAvatar(){
//
//        return null;
//    }


}
