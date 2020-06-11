package ua.daleondeveloper.sao_site.service.serviceImpl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.dao.UserRepository;
import ua.daleondeveloper.sao_site.dao.UserRoleRepository;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
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

    public Long getCount(){return userRepository.count();}
    public Page<User> getAnimeByNumber(int start, int end){
        return userRepository.findAll(PageRequest.of(start,2, Sort.by("email").descending()));
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
            if(user.getRoles() == null) {
                UserRole role_user = roleRepository.findByName("ROLE_USER");
                List<UserRole> roles_list = new ArrayList<>();
                roles_list.add(role_user);
                user.setRoles(roles_list);
            }

            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user = userRepository.save(user);

            return user;
        }else{
            return null;
        }
    }

    @Transactional
    public Long findAvatarId(Long userId){
        Optional<ImageAvatar> imageAvatar = userRepository.findAvatarId(userId);
        if( imageAvatar.isPresent()){
            return imageAvatar.get().getId();
        }else{
            return null;
        }
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
