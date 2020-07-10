package ua.daleondeveloper.sao_site.domain.Files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.*;

@Entity
@Table(name = "Image_Publication")
@Getter
@Setter
@NoArgsConstructor
public class ImagePublication extends Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "anime_Publication_Id")
    private AnimePublication animePublicationImages;

    public ImagePublication(String fileName, String fileType, byte[] data, RoleEnum access, AnimePublication animePublication) {
        super(fileName, fileType, data, access);
        this.animePublicationImages = animePublication;
    }
}
