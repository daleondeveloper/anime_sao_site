package ua.daleondeveloper.sao_site.domain.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UserFactory {
    @Autowired
    private static PasswordEncoder passwordEncoder;

    private static String[] nicknames = new String[]{"Moli","Diablo","Doki","Koko","Lolodom"};

   private static Random random = new Random();

    public static User  getUser(String email, String password){
        List<UserRole> roles = new ArrayList<>();
        roles.add(new UserRole("ROLE_USER"));
        User user = new User(email,password,nicknames[random.nextInt(nicknames.length)],
                roles, LocalDateTime.now(),LocalDateTime.now());
        return user;
    }
    public static User  getUser(String email, String password,List<UserRole> roles){
        User user = getUser(email,password);
        user.setRoles(roles);
        return user;
    }
}
