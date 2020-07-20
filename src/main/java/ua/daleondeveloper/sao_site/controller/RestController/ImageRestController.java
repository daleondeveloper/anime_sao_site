package ua.daleondeveloper.sao_site.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.dto.ImageResponseDto;
import ua.daleondeveloper.sao_site.exception.FileNotFoundException;
import ua.daleondeveloper.sao_site.security.jwt.JwtAuthenticationException;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;
import ua.daleondeveloper.sao_site.utils.constants.FileConstants;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/image/")
public class ImageRestController {

    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DBFileStorageService dbFileStorageService;


    @PostMapping("uploadAvatar")
    public ResponseEntity uploadUserAvatar(@RequestParam("file")MultipartFile file, HttpServletRequest request){
        //Check if file has image type
        if(!file.getContentType().split("/")[0].equals("image")) {
            return ResponseEntity.badRequest().body("Bad image type"); }

        if(file.getSize() > FileConstants.MAX_IMAGE_SIZE){
            return ResponseEntity.badRequest().body("Bad image size");
        }
            Optional<User> tokenUser = userService.findByToken(request);
            if (tokenUser.isPresent()) {
                User user = tokenUser.get();
                try {
                        ImageAvatar avatar = (ImageAvatar) dbFileStorageService.storeFile(
                                new ImageAvatar(file.getName(), file.getContentType(), file.getBytes(), RoleEnum.ROLE_USER, user));
                        userService.updateAvatar(user.getId(), avatar);
                        return ResponseEntity.ok(ImageResponseDto.fromImage(avatar));

                } catch (IOException e) {
                    throw new FileNotFoundException("Not found file");
                }

            } else {
                throw new JwtAuthenticationException("Not found user");
            }

    }

    @GetMapping("getAvatar")
    public ResponseEntity downloadUserAvatar(HttpServletRequest request){
        Optional<User> tokenUser = userService.findByToken(request);
        if(tokenUser.isPresent()){
            ImageAvatar avatar = (ImageAvatar)dbFileStorageService.getFile(
                    userService.findAvatarId(tokenUser.get().getId()),tokenUser.get());
            if(avatar == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No content image by this request");
            }
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(avatar.getContentType()))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + avatar.getFileName() + "\"")
                    .body(Base64.getEncoder().encodeToString(avatar.getData()));
        }else{
            throw new JwtAuthenticationException("Not found user");
        }
    }
}
