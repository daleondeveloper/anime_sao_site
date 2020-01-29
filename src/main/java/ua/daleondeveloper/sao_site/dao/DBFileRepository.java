package ua.daleondeveloper.sao_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.daleondeveloper.sao_site.domain.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile,Long> {
}
