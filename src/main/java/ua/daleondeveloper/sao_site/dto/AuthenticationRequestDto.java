package ua.daleondeveloper.sao_site.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class AuthenticationRequestDto {

    private String email;
    private String password;

}
