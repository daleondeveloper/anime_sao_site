package ua.daleondeveloper.sao_site;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import ua.daleondeveloper.sao_site.domain.Files.File;
import ua.daleondeveloper.sao_site.domain.Files.Image;
import ua.daleondeveloper.sao_site.domain.Files.ImageAvatar;
import ua.daleondeveloper.sao_site.domain.User;
import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.factory.PublicationFactory;
import ua.daleondeveloper.sao_site.domain.factory.UserFactory;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;
import ua.daleondeveloper.sao_site.service.serviceImpl.DBFileStorageService;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserRoleServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.UserServiceImpl;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.PublicationService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.CategoriesService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.TypesService;

import java.io.*;
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
                                  final PublicationService publicationService,
                                  final CategoriesService categoriesService,
                                  final GenreService genreService,
                                  final TypesService typesService,
                                  final DBFileStorageService dbFileStorageService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings)  {
                LocalDate localDate = LocalDate.parse("2019-01-10");
                LocalTime localTime = LocalTime.parse("12:12:12");

                //Adding User
                //Create Roles
                UserRole role_admin = new UserRole("ROLE_ADMIN");
                UserRole role_user = new UserRole("ROLE_USER");
                role_admin = userRoleServiceImpl.saveUserRole(role_admin);
                role_user = userRoleServiceImpl.saveUserRole(role_user);

                List<UserRole> roles = new ArrayList<>();

                byte[] usersStandartAvatar ={};
                try (FileInputStream reader = new FileInputStream("D://icon.jpg")) {

                    byte[] tmpByteArray = new byte[reader.available()];
                    while (reader.available() > 0) {
                        tmpByteArray[tmpByteArray.length - reader.available()] = (byte) reader.read();
                    }
                    usersStandartAvatar = tmpByteArray;

                } catch (IOException e) {
                }
                // Admin users
                //User users
                roles.add(role_user);

                for(int i = 0; i < 20 ; i++){
                    String email = ("daleon" + i + "@ukr.net");
                    User user = UserFactory.getUser(email,"$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a",roles);
                    File file = dbFileStorageService.storeFile(new ImageAvatar("avatar","image/jpg",usersStandartAvatar,RoleEnum.ROLE_GUEST,new Publication()));
                    ImageAvatar imageAvatar = new ImageAvatar(file.getFileName(),file.getContentType(),file.getData(),RoleEnum.ROLE_GUEST,user);
                    user.setAvatarImg(imageAvatar);
                    userServiceImpl.addUser(user);
                }
                roles.add(role_admin);

                userServiceImpl.addUser(UserFactory.getUser("mail@ukr.net","$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a",roles));
                userServiceImpl.addUser(UserFactory.getUser("daleon@ukr.net","$2a$10$81.IeFg8DpDeGhTtpN/MpOla6jjRVFC/PVZJjKfpTNEtWCLS7/06a",roles));
                String [] categories = {"тв", "2012", "драма", "приключения", "романтика", "фэнтези"};
                for(String tmp: categories){
                    categoriesService.save(new Categories(tmp));
                }
                String [] genre = {"приключения", "фэнтези", "романтика", "драма"};
                for(String tmp: genre){
                    genreService.save(new Genre(tmp));
                }
                String [] types = {"Anime","Manga","Game"};
                for(String tmp: types){
                    typesService.save(new Types(tmp));
                }
                byte[] image1 = {};

                try(FileInputStream reader = new FileInputStream("D://SAO_Alicization_MP1.jpg")) {
                    byte[] tmpByteArray = new byte[reader.available()];
                    while (reader.available() > 0) {
                        tmpByteArray[tmpByteArray.length-reader.available()] = (byte)reader.read();
                    }
                    image1 = tmpByteArray;

                }catch (IOException e){
                }
                for(int i = 0, j = 0; i < 100; i++, j++){
                    AnimePublication animePublication = PublicationFactory.getAnimePublication(j,categoriesService,typesService,genreService);
                    publicationService.addPublication(animePublication);
                    File file = dbFileStorageService.storeFile(new ImageAvatar("avatar","image/jpg",image1,RoleEnum.ROLE_GUEST,new Publication()));
                    ImageAvatar imageAvatar = new ImageAvatar(file.getFileName(),file.getContentType(),file.getData(),RoleEnum.ROLE_GUEST,animePublication);
                    imageAvatar.setId(file.getId());
                    publicationService.updateAvatar(animePublication.getId(),imageAvatar);
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
