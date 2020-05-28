package ua.daleondeveloper.sao_site.dao.publication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

@Repository
public interface AnimePublicationRepository extends JpaRepository<AnimePublication, Long> {

    @Modifying
    @Query("UPDATE AnimePublication c SET c.infoImages = (c.infoImages + :imagePublication) WHERE c.id = :id")
    AnimePublication addInfoImage(@Param("id") Long publicationId, @Param("imagePublication") ImagePublication imagePublication);
}
