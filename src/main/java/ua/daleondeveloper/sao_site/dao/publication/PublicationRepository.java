package ua.daleondeveloper.sao_site.dao.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.dao.dynamicDAO.PublicationDynamicRepository;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import java.util.Optional;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long>, PublicationDynamicRepository {


    @Query("SELECT avatarImg FROM Publication c WHERE c.id = :id")
    Optional<ImageAvatar> getAvatar(@Param("id")Long publicationId);


    @Modifying
    @Query("UPDATE Publication c SET c.avatarImg = :imageAvatar WHERE c.id = :id")
    void updateAvatar(@Param("id") Long publicationId, @Param("imageAvatar") ImageAvatar imageAvatar);


}
