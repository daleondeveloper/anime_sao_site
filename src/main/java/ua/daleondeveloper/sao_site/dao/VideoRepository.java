package ua.daleondeveloper.sao_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video,Long> {
}