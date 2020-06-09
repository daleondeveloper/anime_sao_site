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
@Table(name = "Types")
public class Types {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "types")
    private String types;

    @JsonBackReference
    @ManyToMany(mappedBy = "types")
    private List<Publication> publications;

    public Types(String types) {
        this.types = types;
    }
}
