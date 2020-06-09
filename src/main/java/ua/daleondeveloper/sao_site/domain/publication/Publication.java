package ua.daleondeveloper.sao_site.domain.publication;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

//POJO object for post
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Publication")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Publication implements Serializable {

    @Id
    @TableGenerator( name = "genPublicationId", table = "PUBLICATION_ID", pkColumnName = "PUBLICATION_ID", pkColumnValue = "PUBLICATION.ID.PK", valueColumnName = "SEQ_VALUE", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "genPublicationId" )
    private long id;

    //All Strings
    //
    //a description of what is in the post
    @Type(type = "text")
    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "fullName")
    private String fullName;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "director")
    private String director;

    @JoinColumn(name = "language")
    private String language;

    @JoinColumn(name = "groupers")
    private String groupers;

    //Data and Time
    @JoinColumn(name = "createDate")
    private LocalDate createDate;
    @JoinColumn(name = "releaseDateTime")
    private LocalDateTime releaseDateTime;

    @JoinColumn(name = "lastUpdateDateTime")
    private LocalDateTime lastUpdateDateTime;

    //Image
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "avatarImg", referencedColumnName = "id")
    @JsonIgnore
    private ImageAvatar avatarImg;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "publicationTypes",
    joinColumns = {@JoinColumn(name = "publicationId", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "typesId", referencedColumnName = "id")})
    private List<Types> types;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "publicationCategories",
    joinColumns = {@JoinColumn(name = "publicationId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "categoriesId", referencedColumnName = "id")})
    private List<Categories> categories;

    @JsonManagedReference
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "publicationGenre",
    joinColumns = {@JoinColumn(name = "publicationId", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "genreId", referencedColumnName = "id")})
    private List<Genre> genres;
     //Security
    @JoinColumn(name = "access")
    private RoleEnum access;

    public Publication(String description, String fullName, String name, String director, String language, String groupers, LocalDate createDate, LocalDateTime releaseDateTime, LocalDateTime lastUpdateDateTime, List<Types> types, List<Categories> categories, List<Genre> genres, RoleEnum access) {
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.director = director;
        this.language = language;
        this.groupers = groupers;
        this.createDate = createDate;
        this.releaseDateTime = releaseDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
        this.types = types;
        this.categories = categories;
        this.genres = genres;
        this.access = access;
    }

    public void merge(Publication updatePublication){
        if(updatePublication.getDescription() != null)
            this.setDescription(updatePublication.getDescription());
        if(updatePublication.getFullName() != null)
            this.setFullName(updatePublication.getFullName());
        if(updatePublication.getName() != null)
            this.setName(updatePublication.getName());
        if(updatePublication.getDirector() != null)
            this.setDirector(updatePublication.getDirector());
        if(updatePublication.getLanguage() != null)
            this.setLanguage(updatePublication.getLanguage());
        if(updatePublication.getGenres() != null)
            this.setGenres(updatePublication.getGenres());
        if(updatePublication.getCategories() != null)
            this.setCategories(updatePublication.getCategories());
        if(updatePublication.getGroupers() != null)
            this.setGroupers(updatePublication.getGroupers());
        this.setLastUpdateDateTime(LocalDateTime.now());
    }

}
