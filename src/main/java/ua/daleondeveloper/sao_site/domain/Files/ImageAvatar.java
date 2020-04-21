package ua.daleondeveloper.sao_site.domain.Files;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class ImageAvatar extends Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String someTestSecond;

    @OneToOne(mappedBy = "avatarImg", fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;

    public ImageAvatar() {
    }

    public ImageAvatar(String fileName, String fileType, byte[] data, RoleEnum access, User user) {
        super(fileName, fileType, data, access);
        this.user = user;
        this.someTestSecond="6767";
    }
}
