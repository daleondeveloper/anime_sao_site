package ua.daleondeveloper.sao_site.domain.publication;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Manga")
public class MangaPublication extends Publication{

    @JoinColumn(name = "director")
    private String director;

    @JoinColumn(name = "language")
    private String language;

    @JoinColumn(name = "number_of_series")
    private String numberOfSeries;

    @JoinColumn(name = "genre")
    private String genre;

    @JoinColumn(name = "categories")
    private String categories;

    public MangaPublication() {
    }
}
