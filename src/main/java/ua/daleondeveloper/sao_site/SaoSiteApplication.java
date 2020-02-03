package ua.daleondeveloper.sao_site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
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

                UserRole role_admin = new UserRole("ROLE_ADMIN");
                UserRole role_user = new UserRole("ROLE_USER");
                role_admin = userRoleServiceImpl.saveUserRole(role_admin);
                role_user = userRoleServiceImpl.saveUserRole(role_user);

                List<UserRole> roles = new ArrayList<>();

                //roles.add(role_admin);
                roles.add(role_user);
                userServiceImpl.addUser(new User("mail@ukr.net","$2a$10$h.KfO2J.6BIvPTK33kiBGO23hnJ5Wa9eOFg93S4BcapEm737IJNQ6",roles));
                roles.clear();
                roles.add(role_user);
                userServiceImpl.addUser(new User("daleon@ukr.net","$2a$10$71fCELBjrWZYzeNZVCPcD.FNCWb77rf..W4kHQ.wGeMzrp4Ax3noq",roles));
                userServiceImpl.addUser(new User("third@ukr.net","3333"));

//                userServiceImpl.register(new User("mai11@ukr.net","1111"));

//                Group group = new Group("Test");
//                Contact contact;
//
//                contactService.addGroup(group);
//
//                for (int i = 0; i < 13; i++) {
//                    contact = new Contact(null, "Name" + i, "Surname" + i, "1234567" + i, "user" + i + "@test.com");
//                    contactService.addContact(contact);
//                }
//                for (int i = 0; i < 10; i++) {
//                    contact = new Contact(group, "Other" + i, "OtherSurname" + i, "7654321" + i, "user" + i + "@other.com");
//                    contactService.addContact(contact);
//                }
            }
        };
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
