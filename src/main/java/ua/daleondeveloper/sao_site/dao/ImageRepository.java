package ua.daleondeveloper.sao_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.Image;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
