package ua.daleondeveloper.sao_site.domain.publication;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

    @JoinColumn(name = "types")
    private String types;

    @JoinColumn(name = "fullName")
    private String fullName;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "director")
    private String director;

    @JoinColumn(name = "language")
    private String language;

    @JoinColumn(name = "genre")
    private String genre;

    @JoinColumn(name = "categories")
    private String categories;

    @JoinColumn(name = "postInfoShort")
    private String postInfoShort;

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
    @JsonManagedReference
    private ImageAvatar avatarImg;

    //Security
    @JoinColumn(name = "access")
    private RoleEnum access;

    public Publication(String description, String fullName, String name, String director, String language, String genre, String categories, String postInfoShort, String groupers, LocalDateTime releaseDateTime, LocalDateTime lastUpdateDateTime, RoleEnum access) {
        this.description = description;
        this.fullName = fullName;
        this.name = name;
        this.director = director;
        this.language = language;
        this.genre = genre;
        this.categories = categories;
        this.postInfoShort = postInfoShort;
        this.groupers = groupers;
        this.releaseDateTime = releaseDateTime;
        this.lastUpdateDateTime = lastUpdateDateTime;
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
        if(updatePublication.getGenre() != null)
            this.setGenre(updatePublication.getGenre());
        if(updatePublication.getCategories() != null)
            this.setCategories(updatePublication.getCategories());
        if(updatePublication.getPostInfoShort() != null)
            this.setPostInfoShort(updatePublication.getPostInfoShort());
        if(updatePublication.getGroupers() != null)
            this.setGroupers(updatePublication.getGroupers());
        this.setLastUpdateDateTime(LocalDateTime.now());
    }

}
