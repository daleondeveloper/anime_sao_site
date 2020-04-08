package ua.daleondeveloper.sao_site.controller.RestController;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.dto.UserDto;
import ua.daleondeveloper.sao_site.security.jwt.JwtAuthenticationException;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/v1/user/")
public class UserRestController {


    private UserServiceImpl userServiceImpl;
    private DBFileStorageService dbFileStorageService;
    private JwtTokenProvider jwtTokenProvider;


    @GetMapping(value = "getUserInfo")
    public ResponseEntity getUserInfo(HttpServletRequest httpServletRequest){

            Optional<User> tokenUser = userServiceImpl.findByToken(httpServletRequest);
            if(tokenUser.isPresent()) {
                return ResponseEntity.ok(UserDto.fromUser(tokenUser.get()));
            }else{
                throw new JwtAuthenticationException("Not found user");
            }

    }
//    @PostMapping("updateAvatar")
//    public UploadFileResponse uploadAvatar(@RequestParam("avatar")MultipartFile avatarReq,
//                                           HttpServletRequest httpServletRequest){
//                Optional<User> tokenUser = userServiceImpl.findByEmail(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(httpServletRequest)));
//
//                    tokenUser.ifPresent(user -> userServiceImpl.updateAvatar(user.getId(), avatarReq));
//
//                return new UploadFileResponse(avatarReq.getName(), "",
//                        avatarReq.getContentType(), avatarReq.getSize());
//    }

//    @PostMapping("getAvatar")
//    public ResponseEntity<Resource> getAvatar(HttpServletRequest httpServletRequest) {
//
//        Optional<User> tokenUser = userServiceImpl.findByToken(httpServletRequest);
//
////        if (tokenUser.isPresent() && tokenUser.get().getImage_main() != null) {
////
////            return ResponseEntity.ok()
////                    .contentType(MediaType.parseMediaType("image/jpeg"))
////                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + "avatar" + "\"")
////                    .body(new ByteArrayResource(tokenUser.get().getImage_main()));
////
////        } else {
////            throw new FileNotFoundException("File not found with id ");
////        }
//    }

}
