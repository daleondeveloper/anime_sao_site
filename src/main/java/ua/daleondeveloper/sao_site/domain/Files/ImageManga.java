package ua.daleondeveloper.sao_site.domain.Files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.publication.MangaPublication;

import javax.persistence.*;

@Entity
@Table(name = "Image_Manga")
@Getter
@Setter
@NoArgsConstructor
public class ImageManga extends Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    private MangaPublication mangaPublication;

}
