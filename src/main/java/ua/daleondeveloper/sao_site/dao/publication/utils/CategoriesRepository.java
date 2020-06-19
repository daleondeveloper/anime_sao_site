package ua.daleondeveloper.sao_site.dao.publication.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;

import java.util.List;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {

    @Query("SELECT c FROM Categories c WHERE c.categories LIKE \n" +
            "lower(CONCAT('%',:txt,'%'))")
    List<Categories> getCategoriesTxt(@Param("txt") String txt);
}
