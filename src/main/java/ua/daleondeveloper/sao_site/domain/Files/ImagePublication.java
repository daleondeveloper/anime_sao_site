package ua.daleondeveloper.sao_site.domain.Files;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.*;

@Entity
@Table(name = "ImagePublication")
@Getter
@Setter
@NoArgsConstructor
public class ImagePublication extends Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @ManyToOne
//    private Publication publication;
}
