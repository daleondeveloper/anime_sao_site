package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;

import javax.persistence.*;
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

}
