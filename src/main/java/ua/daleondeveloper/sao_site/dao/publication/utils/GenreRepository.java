package ua.daleondeveloper.sao_site.dao.publication.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {

    @Query("SELECT c FROM Genre WHERE c.genre LIKE \n" +
            "lower(CONCAT('%',:txt,'%'))")
    Page<Genre> getGenreTxt(@Param("txt") String txt);
}
