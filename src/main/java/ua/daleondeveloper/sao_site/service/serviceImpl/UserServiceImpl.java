package ua.daleondeveloper.sao_site.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.dao.UserRepository;
import ua.daleondeveloper.sao_site.dao.UserRoleRepository;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.security.jwt.JwtAuthenticationException;
import ua.daleondeveloper.sao_site.security.jwt.JwtTokenProvider;
import ua.daleondeveloper.sao_site.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    public UserServiceImpl(JwtTokenProvider jwtTokenProvider, UserRepository userRepository, UserRoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Transactional
    public void addUser(User user){userRepository.save(user);}

    @Transactional
    public void updateAvatar (Long userId, ImageAvatar imageId) {
        userRepository.updateAvatar(userId,imageId);
    }


    @Override
    @Transactional
    public User register(User user) {
        if(user.getEmail() != null && user.getPassword() != null) {
            UserRole role_user = roleRepository.findByName("ROLE_USER");
            List<UserRole> roles_list = new ArrayList<>();
            roles_list.add(role_user);

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roles_list);
            user = userRepository.save(user);

            return user;
        }else{
            return null;
        }
    }

    public Long findAvatarId(Long userId){
       return userRepository.findAvatarId(userId).get().getId();
    }

    @Transactional
    public Optional<User> findByEmail(String email){return userRepository.findByEmail(email);}

    public Optional<User> findByToken(HttpServletRequest request) throws JwtAuthenticationException {
        return userRepository.findByEmail(jwtTokenProvider.getUsername(
                jwtTokenProvider.resolveToken(request)));}

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }



}
