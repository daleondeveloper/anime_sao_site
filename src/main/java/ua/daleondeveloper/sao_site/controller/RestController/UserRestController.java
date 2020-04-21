package ua.daleondeveloper.sao_site.controller.RestController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "getUserInfo")
    public ResponseEntity getUserInfo(HttpServletRequest httpServletRequest){

            Optional<User> tokenUser = userServiceImpl.findByToken(httpServletRequest);
            if(tokenUser.isPresent()) {
                return ResponseEntity.ok(UserDto.fromUser(tokenUser.get()));
            }else{
                throw new JwtAuthenticationException("Not found user");
            }

    }

}
