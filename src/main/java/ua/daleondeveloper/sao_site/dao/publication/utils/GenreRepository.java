package ua.daleondeveloper.sao_site.dao.publication.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

    //Отримати усі жанри що містять частину тексту 'txt'
    @Query("SELECT c FROM Genre c WHERE c.genre LIKE \n" +
            "lower(CONCAT('%',:txt,'%'))")
    List<Genre> getGenreTxt(@Param("txt") String txt);
}
