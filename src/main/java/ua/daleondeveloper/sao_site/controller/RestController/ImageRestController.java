package ua.daleondeveloper.sao_site.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.File;
import ua.daleondeveloper.sao_site.domain.Files.Image;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.dto.ImageResponse;
import ua.daleondeveloper.sao_site.security.jwt.JwtAuthenticationException;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.ImageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/image/")
public class ImageRestController {

    @Autowired
    private ImageService imageService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private FileRestController fileRestController;
    @Autowired
    private DBFileStorageService dbFileStorageService;


    @PostMapping("uploadAvatar")
    public ResponseEntity uploadUserAvatar(@RequestParam("file")MultipartFile file, HttpServletRequest request){

        Optional<User> tokenUser = userService.findByToken(request);
        if(tokenUser.isPresent()) {
            User user = tokenUser.get();
            if(user.getImageId() >= 0 ){
                Image avatar = imageService.storeImage(file);
                userService.updateAvatar(user.getId(),avatar.getId());
                return ResponseEntity.ok(ImageResponse.fromUser(avatar));
            }

        }else{
            throw new JwtAuthenticationException("Not found user");
        }

        return (ResponseEntity) ResponseEntity.badRequest();
    }

    @GetMapping("getAvatar")
    public ResponseEntity downloadUserAvatar(HttpServletRequest request){
        Optional<User> tokenUser = userService.findByToken(request);
        if(tokenUser.isPresent()){
//            Image avatar = imageService.getImage(tokenUser.get().getImageId());
           return fileRestController.downloadFile(tokenUser.get().getImageId(), request);
//            return ResponseEntity.ok()
//                    .contentType(MediaType.parseMediaType(avatar.getContentType()))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + avatar.getFileName() + "\"")
//                    .body(Base64.getEncoder().encodeToString(avatar.getData()));
        }else{
            throw new JwtAuthenticationException("Not found user");
        }
    }
}
