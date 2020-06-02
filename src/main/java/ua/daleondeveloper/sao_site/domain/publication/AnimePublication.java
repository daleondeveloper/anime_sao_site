package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "AnimePublication")
@Getter
@Setter
@NoArgsConstructor
public class AnimePublication extends Publication{
    //Video
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "animePublicationImages")
    private List<ImagePublication> infoImages;

    public AnimePublication( String description, String fullName, String name, String director, String language, String genre, String categories, String postInfoShort, String groupers, LocalDateTime releaseDateTime, LocalDateTime lastUpdateDateTime, RoleEnum access) {
        super(description, fullName, name, director, language, genre, categories, postInfoShort, groupers, releaseDateTime, lastUpdateDateTime, access);
    }
}
