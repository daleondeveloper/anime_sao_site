package ua.daleondeveloper.sao_site.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Modifying
    @Query("UPDATE User c SET c.avatarImg = :imageId WHERE c.id = :id")
    void updateAvatar(@Param("id") Long userId, @Param("imageId") ImageAvatar imageId);

    @Query("SELECT c FROM User c WHERE c.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Transactional
    @Query("SELECT avatarImg FROM User c  where c.id = :id")
    Optional<ImageAvatar> findAvatarId(@Param("id")Long id);
}
