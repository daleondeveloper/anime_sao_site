package ua.daleondeveloper.sao_site.dao.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {

    @Query("UPDATE Publication c SET c.description = :#{#publication.description}, " +
            "c.fullName = :#{#publication.fullName}, c.access = :#{#publication.access}, " +
            "c.description = :#{#publication.description}, c.name = :#{#publication.name}," +
            "c.director = :#{#publication.director}, c.genre = :#{#publication.genre}," +
            "c.categories = :#{#publication.categories}, c.language = :#{#publication.language}," +
            "c.lastUpdateDate = :#{#publication.lastUpdateDate}, c.lastUpdateTime = :#{#publication.lastUpdateTime}," +
            "c.postInfoShort = :#{#publication.postInfoShort}, c.groupers = :#{#publication.groupers}"  +
            " WHERE c.id = :#{#publication.getId}")
    Publication updatePublication(@Param("publication")Publication publication);
}
