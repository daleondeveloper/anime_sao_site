package ua.daleondeveloper.sao_site.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Getter
@Setter
public class PublicationDto {

    private long id;

    //All Strings
    //
    //a description of what is in the post
    private String description;
    private String fullName;
    private String name;
    private String director;
    private String language;
    private String genre;
    private String categories;
    private String postInfoShort;
    private String group;

    //Data and Time
    private LocalDate releaseDate;
    private LocalTime releaseTime;
    private LocalDate lastUpdateDate;
    private LocalTime lastUpdateTime;

    public Publication toPublication(){
        Publication publication = new Publication();
        publication.setId(this.id);
        publication.setDescription(this.description);
        publication.setFullName(this.fullName);
        publication.setName(this.name);
        publication.setDirector(this.director);
        publication.setLanguage(this.language);
        publication.setGenre(this.genre);
        publication.setCategories(this.categories);
        publication.setPostInfoShort(this.postInfoShort);
//        publication.setGroup(this.group);
        publication.setReleaseDate(this.releaseDate);
        publication.setReleaseTime(this.releaseTime);
        publication.setLastUpdateDate(this.lastUpdateDate);
        publication.setLastUpdateTime(this.lastUpdateTime);

        return publication;
    }

    public PublicationDto fromPublication(Publication publication){
        PublicationDto publicationDto  = new PublicationDto();
        publicationDto.setId(publication.getId());
        publicationDto.setDescription(publication.getDescription());
        publicationDto.setFullName(publication.getFullName());
        publicationDto.setName(publication.getName());
        publicationDto.setDirector(publication.getDirector());
        publicationDto.setLanguage(publication.getLanguage());
        publicationDto.setGenre(publication.getGenre());
        publicationDto.setCategories(publication.getCategories());
        publicationDto.setPostInfoShort(publication.getPostInfoShort());
//        publicationDto.setGroup(publication.getGroup());
        publicationDto.setReleaseDate(publication.getReleaseDate());
        publicationDto.setReleaseTime(publication.getReleaseTime());
        publicationDto.setLastUpdateDate(publication.getLastUpdateDate());
        publicationDto.setLastUpdateTime(publication.getLastUpdateTime());

        return publicationDto;
    }
}
