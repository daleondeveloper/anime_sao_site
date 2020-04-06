package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

//POJO object for post
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@AllArgsConstructor
public class Publication implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //All Strings
    //
    //a description of what is in the post
    @JoinColumn(name = "description")
    private String description;

    @JoinColumn(name = "full_name")
    private String full_name;

    @JoinColumn(name = "name")
    private String name;

    @JoinColumn(name = "post_info_short")
    private String post_info_short;

    //Data and Time
    @JoinColumn(name = "release_date")
    private LocalDate releaseDate;

    @JoinColumn(name = "last_update_date")
    private LocalDate lastUpdateDate;

    //Image
    @JoinColumn(name = "mainImage")
    private long mainImage;

    public Publication(){}
}
