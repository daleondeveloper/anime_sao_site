package ua.daleondeveloper.sao_site.dao.publication.utils;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;

@Repository
public interface CategoriesRepository extends JpaRepository<Categories,Long> {
}
