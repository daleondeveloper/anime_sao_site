package ua.daleondeveloper.sao_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.Files.File;

@Repository
public interface DBFileRepository extends JpaRepository<File,Long> {
}
