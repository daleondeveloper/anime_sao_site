package ua.daleondeveloper.sao_site.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.User;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String nickName;
    private String email;
    private String password;
    private String acess;
    private LocalDateTime lastUpdateDateTime;

    public User toUser(){
        User user = new User();
        if(id != null) {
            user.setId(id);
        }else{
            user.setId(0);
        }
        user.setNickname(nickName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAccess(acess);
        user.setLastUpdateDateTime(lastUpdateDateTime);

        return user;
    }

    public static UserDto fromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNickName(user.getNickname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAcess(user.getAccess());
        userDto.setLastUpdateDateTime(user.getLastUpdateDateTime());
        return userDto;
    }
}
