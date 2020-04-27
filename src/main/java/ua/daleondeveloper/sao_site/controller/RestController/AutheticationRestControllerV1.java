package ua.daleondeveloper.sao_site.controller.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.dto.AuthenticationRequestDto;
import ua.daleondeveloper.sao_site.dto.UserDto;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;
import ua.daleondeveloper.sao_site.service.UserService;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AutheticationRestControllerV1 {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AutheticationRestControllerV1(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity login ( AuthenticationRequestDto requestDto){

        try{
            String email = requestDto.getEmail();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, requestDto.getPassword()));
            Optional<User> user = userService.findByEmail(email);

            if(!user.isPresent()){
                throw new UsernameNotFoundException("User with email : " + email + " not found.");
            }

            String token = jwtTokenProvider.createToken(email, user.get().getRoles());

            Map<Object,Object> responce = new HashMap<>();
            responce.put("email",email);
            responce.put("token",token);

            return ResponseEntity.ok(responce);
        }catch (AuthenticationException e){
            throw new BadCredentialsException("Invalid email or password");
        }
    }

    @PostMapping("registration")
    public ResponseEntity register ( UserDto userRequestDto){
        if(userRequestDto.getEmail() != null && userRequestDto.getPassword() != null){

            Optional<User> userOp = userService.findByEmail(userRequestDto.getEmail());
            if(userOp.isPresent()){
                throw new BadCredentialsException("Email is register");
            }
            if(userRequestDto.getNickName() == null || userRequestDto.getNickName().isEmpty() ){
                userRequestDto.setNickName("NewUser");
            }

            userRequestDto.setLastUpdateDate(LocalDate.now());

            User userResponse = userRequestDto.toUser();
            userResponse =  userService.register(userResponse);

            return ResponseEntity.ok(UserDto.fromUser(userResponse)) ;
        }


        throw new BadCredentialsException("Invalid email or password");

    }
}
