package ua.daleondeveloper.sao_site.domain.publication;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "GamePublication")
@Getter
@Setter
@NoArgsConstructor
public class GamePublication extends Publication{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "url")
    private String downloadUrl;
}
