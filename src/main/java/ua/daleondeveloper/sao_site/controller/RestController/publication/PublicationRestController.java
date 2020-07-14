package ua.daleondeveloper.sao_site.controller.RestController.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.dto.ImageResponseDto;
import ua.daleondeveloper.sao_site.dto.UploadFileResponseDto;
import ua.daleondeveloper.sao_site.exception.BadFileTypeException;
import ua.daleondeveloper.sao_site.exception.FileToBigException;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.utils.FileCheker;
import ua.daleondeveloper.sao_site.utils.constants.FileConstants;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/publication/")
public class PublicationRestController {

    @Autowired
    private PublicationService publicationService;
    @Autowired
    private DBFileStorageService dbFileStorageService;

    @GetMapping("getNumberOfPublication")
    public ResponseEntity get_number_of_publication(){

        return ResponseEntity.ok(publicationService.getCount());
    }
    @GetMapping(value = "getPublication/{page}")
    public  ResponseEntity get_publication(@PathVariable(name = "page")int page){
        return ResponseEntity.ok(publicationService.getPublicationByNumber(page,page+3));
    }

    @PostMapping(value = "uploadAvatar/{id}")
    public ResponseEntity uploadAvatar (@RequestParam("file")MultipartFile requestFile, @PathVariable(name = "id")Long id) {

            Optional<Publication> publication = publicationService.findById(id);
            try {
                if (publication.isPresent() && FileCheker.chekImageFile(requestFile)) {

                    ImageAvatar imageAvatar = (ImageAvatar) dbFileStorageService.storeFile(
                            new ImageAvatar(requestFile.getName(), requestFile.getContentType(), requestFile.getBytes(), RoleEnum.ROLE_GUEST, publication.get()));

                    publicationService.updateAvatar(publication.get().getId(), imageAvatar);

                    return ResponseEntity.ok(ImageResponseDto.fromImage(imageAvatar));
                }
            }catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        return ResponseEntity.ok().body("Image not download");
    }

    @GetMapping(value = "getAvatar/{id}")
    public ResponseEntity getAvatar(@PathVariable("id")long id){
        ImageAvatar avatar = (ImageAvatar)dbFileStorageService.getFile(publicationService.findAvatarId(id),null);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(avatar.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + avatar.getFileName() + "\"")
                .body(Base64.getEncoder().encodeToString(avatar.getData()));
    }


}
