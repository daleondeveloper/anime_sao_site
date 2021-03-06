package ua.daleondeveloper.sao_site.domain.Files;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Image_Avatar")
@Getter
@Setter
@NoArgsConstructor
public class ImageAvatar extends Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "avatarImg", fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;

    @OneToOne(mappedBy = "avatarImg", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Publication publication;

    public ImageAvatar(String fileName, String fileType, byte[] data, RoleEnum access, User user) {
        super(fileName, fileType, data, access);
        this.user = user;
    }

    public ImageAvatar(String fileName, String fileType, byte[] data, RoleEnum access, Publication publication) {
        super(fileName, fileType, data, access);
        this.publication = publication;
    }
}
