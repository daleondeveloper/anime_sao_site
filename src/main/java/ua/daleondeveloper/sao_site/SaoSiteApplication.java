package ua.daleondeveloper.sao_site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserRoleServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;

import java.time.LocalDate;
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
                                  final UserRoleServiceImpl userRoleServiceImpl) {
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

                userServiceImpl.addUser(new User("mail@ukr.net","$2a$10$htuylAmgsFeg0F1yVWk2e.Cr/0a3P5VgZjoT0qMsWuyEa4JJxUS1S","admin1",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon@ukr.net","$2a$10$6m6jO4ztTxR/7CxhRl5KmO68wj9/oNT.XSQOiDmuN2OFQavzmeMhu","admin2",roles, LocalDate.now()));
                roles.clear();
                //Non admin users
                roles.add(role_user);
                userServiceImpl.addUser(new User("daleon1@mail.ru","$2a$10$ox.IvgI54mBB8uz54sQ9xOOK7pUK6qOHrLZMEyJZP9ko7/E0mv/F6","daleon1",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon2@mail.ru","$2a$10$PWL/tptqCQczmSDKJ4axZ.buICvxPjBxSGwCPnqjIiaf.lOp2udSe","daleon2",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon3@mail.ru","$2a$10$uRT8lYP69Ffq3nECSLKXPO1RnGm.Ggd4IeOi59jFMev33nm7kXqI.","daleon3",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon4@mail.ru","$2a$10$h.M7BpBLdz9SAt2oL.z.d.vjYB7I2LJWBjCuNszEN9lIAvVjLRRay","daleon4",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon5@mail.ru","$2a$10$TgFSGsjU/qioNzW5lWjGCeZxAENZH4Zvbc7a4Ljl1GqrJP/buQ29i","daleon5",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon6@mail.ru","$2a$10$oPEaUYnxkctH68kBN2F7WuqOdV3Sf8evrznQxbRT0PqnSTGELdhz2","daleon6",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon7@mail.ru","$2a$10$Cdwq2R3bS0YKT88KMtjb1enRe3Ey35egHJOTuWTAf3zgT1pnNfm.S","daleon7",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon8@mail.ru","$2a$10$4z6r/rdB0Id7Jg38f8mTGeTh3vccFBcXzDls5vwEp89gBLvgbiENy","daleon8",roles,LocalDate.now()));
                userServiceImpl.addUser(new User("daleon9@mail.ru","$2a$10$ANd64k0PngMJKSZFoBwuQOLJCNS9T/OTLGlPO.sz2cHdERCBmMbKy","daleon9",roles,LocalDate.now()));


            }
        };
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
