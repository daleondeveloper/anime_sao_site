package ua.daleondeveloper.sao_site.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import java.time.LocalDateTime;

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
    private LocalDateTime releaseDateTime;
    private LocalDateTime lastUpdateDateTime;

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
        publication.setGroupers(this.group);
        publication.setReleaseDateTime(this.releaseDateTime);
        publication.setLastUpdateDateTime(this.lastUpdateDateTime);

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
        publicationDto.setGroup(publication.getGroupers());
        publicationDto.setReleaseDateTime(publication.getReleaseDateTime());
        publicationDto.setLastUpdateDateTime(publication.getLastUpdateDateTime());

        return publicationDto;
    }
}
