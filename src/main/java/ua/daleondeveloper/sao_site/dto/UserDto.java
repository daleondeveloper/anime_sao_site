package ua.daleondeveloper.sao_site.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import ua.daleondeveloper.sao_site.domain.User;

import java.time.LocalDate;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    private Long id;
    private String nickName;
    private String email;
    private String password;
    private String acess;
    private Long imageId;
    private LocalDate lastUpdateDate;

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
        //user.setImageId(imageId);
        user.setImageId(0);
        user.setLastUpdateDate(lastUpdateDate);

        return user;
    }

    public static UserDto fromUser(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNickName(user.getNickname());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAcess(user.getAccess());
        userDto.setImageId(user.getImageId());
        userDto.setLastUpdateDate(user.getLastUpdateDate());
        return userDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAcess() {
        return acess;
    }

    public void setAcess(String acess) {
        this.acess = acess;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
