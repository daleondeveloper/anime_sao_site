package ua.daleondeveloper.sao_site.dao.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long> {

    @Query("SELECT COUNT(*) FROM Publication ")
    Long getCountOfAllPublication();
}
