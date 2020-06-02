package ua.daleondeveloper.sao_site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.factory.PublicationFactory;
import ua.daleondeveloper.sao_site.domain.factory.UserFactory;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserRoleServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//@Configuration
//@EnableJpaRepositories(basePackages = {"ua.daleondeveloper.sao_site"})
//@EnableTransactionManagement
@SpringBootApplication
public class SaoSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaoSiteApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(final UserServiceImpl userServiceImpl,
                                  final UserRoleServiceImpl userRoleServiceImpl,
                                  final PublicationService publicationService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                LocalDate localDate = LocalDate.parse("2019-01-10");
                LocalTime localTime = LocalTime.parse("12:12:12");

                //Adding User
                    //Create Roles
                UserRole role_admin = new UserRole("ROLE_ADMIN");
                UserRole role_user = new UserRole("ROLE_USER");
                role_admin = userRoleServiceImpl.saveUserRole(role_admin);
                role_user = userRoleServiceImpl.saveUserRole(role_user);

                List<UserRole> roles = new ArrayList<>();

                // Admin users
                roles.add(role_admin);
                roles.add(role_user);
                userServiceImpl.addUser(UserFactory.getUser("mail@ukr.net","1234",roles));
                userServiceImpl.addUser(UserFactory.getUser("daleon@ukr.net","1234",roles));
                //User users
                for(int i = 0; i < 20 ; i++){
                    String email = ("daleon" + i + "@ukr.net");
                    userServiceImpl.addUser(UserFactory.getUser(email,"$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a",roles));
                }
                for(int i = 0, j = 0; i < 95; i++, j++){
                    Publication animePublication = PublicationFactory.getAnimePublication(j);
                    publicationService.addPublication(animePublication);
                            if(j == 6 )j = 0;
                }
            }
        };
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
