package ua.daleondeveloper.sao_site.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.daleondeveloper.sao_site.domain.DBFile;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.dto.UploadFileResponse;
import ua.daleondeveloper.sao_site.exception.MyFileNotFoundException;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenDecode;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private DBFileStorageService dbFileStorageService;
    private JwtTokenProvider jwtTokenProvider;

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

        Optional<User> tokenUser = userServiceImpl.findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));

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
