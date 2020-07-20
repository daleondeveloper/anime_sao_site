package ua.daleondeveloper.sao_site.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.CategoriesService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;
import ua.daleondeveloper.sao_site.utils.StringParser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class AnimePublicationDto {

    private long id;

    //All Strings
    //
    //a description of what is in the post
    private String description;
    private String fullName;
    private String name;
    private String director;
    private String language;
    private List<String> genre = new ArrayList<>();
    private List<String> categories = new ArrayList<>();
    private List<Types> types;
    private String postInfoShort;
    private String group;
    private int countSeries;

    //Data and Time
    private LocalDateTime releaseDateTime;
    private LocalDateTime lastUpdateDateTime;

    public AnimePublication toAnimePublication(GenreService genreService, CategoriesService categoriesService){
        AnimePublication publication = new AnimePublication();
        publication.setId(this.id);
        publication.setDescription(this.description);
        publication.setFullName(this.fullName);
        publication.setName(this.name);
        publication.setDirector(this.director);
        publication.setLanguage(this.language);
        List<Genre> genreList = new ArrayList<>();
        for(String s : genre){
            s = StringParser.parseJSONRequestStringMassive(s);
            List<Genre> bdGenreList = genreService.getByTxt(s);
            if(!bdGenreList.isEmpty()) {
                genreList.add(bdGenreList.get(0));
            }

        }
        publication.setGenres(genreList);
        List<Categories> categoriesList = new ArrayList<>();
        for(String s : categories){
            s = StringParser.parseJSONRequestStringMassive(s);
            List<Categories> bdCategoriesList = categoriesService.getByTxt(s);
            if(!bdCategoriesList.isEmpty()) {
                categoriesList.add(categoriesList.get(0));
            }
        }
        publication.setCategories(categoriesList);
        publication.setTypes(this.types);
        publication.setGroupers(this.group);
        publication.setCountSeries(this.countSeries);
        publication.setReleaseDateTime(this.releaseDateTime);
        publication.setLastUpdateDateTime(this.lastUpdateDateTime);

        return publication;
    }

    public AnimePublicationDto fromAnimePublication(AnimePublication publication){
        AnimePublicationDto publicationDto  = new AnimePublicationDto();
        publicationDto.setId(publication.getId());
        publicationDto.setDescription(publication.getDescription());
        publicationDto.setFullName(publication.getFullName());
        publicationDto.setName(publication.getName());
        publicationDto.setDirector(publication.getDirector());
        publicationDto.setLanguage(publication.getLanguage());
        List<String> stringGenreList = new ArrayList<>();
        for(Genre g : publication.getGenres()){
            stringGenreList.add(g.getGenre());
        }
        publicationDto.setGenre(stringGenreList);
        List<String> stringCategoriesList = new ArrayList<>();
        for(Categories cat : publication.getCategories()){
            stringGenreList.add(cat.getCategories());
        }
        publicationDto.setCategories(stringCategoriesList);
        publicationDto.setTypes(publication.getTypes());
        publicationDto.setGroup(publication.getGroupers());
        publicationDto.setCountSeries(publication.getCountSeries());
        publicationDto.setReleaseDateTime(publication.getReleaseDateTime());
        publicationDto.setLastUpdateDateTime(publication.getLastUpdateDateTime());

        return publicationDto;
    }
}
