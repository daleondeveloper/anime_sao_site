package ua.daleondeveloper.sao_site.domain.publication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;

import javax.persistence.*;
import java.time.LocalDate;
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

    @JoinColumn(name = "countSeries")
    private int countSeries;

    @JsonIgnore
    @OneToMany(mappedBy = "animePublicationImages")
    private List<ImagePublication> infoImages;

    public AnimePublication(String description, String fullName, String name, String director, String language, String groupers, LocalDate createDate, LocalDateTime releaseDateTime, LocalDateTime lastUpdateDateTime, List<Types> types, List<Categories> categories, List<Genre> genres, RoleEnum access, int countSeries) {
        super(description, fullName, name, director, language, groupers, createDate, releaseDateTime, lastUpdateDateTime, types, categories, genres, access);
        this.countSeries = countSeries;
    }
}
