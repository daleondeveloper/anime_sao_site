package ua.daleondeveloper.sao_site.domain.publication.utils;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "genre")
    private String genre;

    @JsonBackReference
    @ManyToMany(mappedBy = "genres")
    private List<Publication> publications;

    public Genre(String genre){
        this.genre = genre;
    }
}
