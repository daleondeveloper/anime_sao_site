package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.Files.ImageManga;

import javax.persistence.*;

@Entity
@Table(name = "MangaPublication")
@Getter
@Setter
@NoArgsConstructor
public class MangaPublication extends Publication{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "numberOfPages")
    private String numberOfPages;

//    @OneToMany
//    private ImageManga imageManga;


}
