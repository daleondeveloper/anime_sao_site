package ua.daleondeveloper.sao_site.service;

import ua.daleondeveloper.sao_site.domain.User;

import java.util.Optional;

public interface UserService {

    User register(User user);

    Optional<User> findByEmail(String mail);

    Optional<User> findById(Long id);

}
