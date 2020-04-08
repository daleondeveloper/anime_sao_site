package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Game")
@Getter
@Setter
@AllArgsConstructor
public class GamePublication extends Publication{
    @JoinColumn(name = "director")
    private String director;

    @JoinColumn(name = "language")
    private String language;
}
