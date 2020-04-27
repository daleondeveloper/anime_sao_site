package ua.daleondeveloper.sao_site.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.User;

@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminUserDto {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String status;

    public User toUser() {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        return user;
    }

    public static AdminUserDto fromUser(User user) {
        AdminUserDto adminUserDto = new AdminUserDto();
        adminUserDto.setId(user.getId());
        adminUserDto.setEmail(user.getEmail());
        return adminUserDto;
    }

}
