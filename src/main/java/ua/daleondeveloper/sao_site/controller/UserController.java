package ua.daleondeveloper.sao_site.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.DBFile;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.dto.UploadFileResponse;
import ua.daleondeveloper.sao_site.dto.UserDto;
import ua.daleondeveloper.sao_site.exception.MyFileNotFoundException;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenDecode;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/user/")
public class UserController {


    private UserServiceImpl userServiceImpl;
    private DBFileStorageService dbFileStorageService;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, DBFileStorageService dbFileStorageService, JwtTokenProvider jwtTokenProvider) {
        this.userServiceImpl = userServiceImpl;
        this.dbFileStorageService = dbFileStorageService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping(value = "getUserInfo")
    public ResponseEntity getUserInfo(HttpServletRequest httpServletRequest){
        Optional<User> tokenUser = userServiceImpl.findByToken(httpServletRequest);
        if(tokenUser.isPresent()){
            return ResponseEntity.ok(UserDto.fromUser(tokenUser.get()));
        }else{
            return ResponseEntity.badRequest().body("User not found");
        }

    }
    @PostMapping("updateAvatar")
    public UploadFileResponse uploadAvatar(@RequestParam("avatar")MultipartFile avatarReq,
                                           HttpServletRequest httpServletRequest){
                Optional<User> tokenUser = userServiceImpl.findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));

                    tokenUser.ifPresent(user -> userServiceImpl.updateAvatar(user.getId(), avatarReq));

                return new UploadFileResponse(avatarReq.getName(), "",
                        avatarReq.getContentType(), avatarReq.getSize());
    }

    @PostMapping("getAvatar")
    public ResponseEntity<Resource> getAvatar(HttpServletRequest httpServletRequest) {

        Optional<User> tokenUser = userServiceImpl.findByToken(httpServletRequest);

        if (tokenUser.isPresent() && tokenUser.get().getImage_main() != null) {

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/jpeg"))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "avatar" + "\"")
                    .body(new ByteArrayResource(tokenUser.get().getImage_main()));

        } else {
            throw new MyFileNotFoundException("File not found with id ");
        }
    }

}
