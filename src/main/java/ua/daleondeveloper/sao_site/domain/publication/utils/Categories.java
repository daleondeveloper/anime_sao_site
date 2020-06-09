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
@Table(name = "Categories")
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "categories")
    private String categories;

    @JsonBackReference
    @ManyToMany(mappedBy = "categories")
    private List<Publication> publications;

    public Categories(String categories) {
        this.categories = categories;
    }
}
