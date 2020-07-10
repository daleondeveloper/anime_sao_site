package ua.daleondeveloper.sao_site.domain.factory;

import ua.daleondeveloper.sao_site.domain.UserRole;
import ua.daleondeveloper.sao_site.domain.dao_enum.RoleEnum;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.CategoriesService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.TypesService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PublicationFactory {

    private static String[] description = new String[]{
      "Любите ли вы онлайн игры?\n" +
              "\n" +
              "В 2022 году людям удалось создать совершенную виртуальную реальность. Посредством специального шлема с нейроприводом, любой желающий мог погрузиться в виртуальность игры и буквально жить там, как в реальности. Мастера меча онлайн – новая онлайн игра, выхода который ждали миллионы геймеров. Все бы ничего, но у главного разработчика свои планы в отношении игроков… Они будут жить в игре, пока не пройдут ее полностью, иначе – смерть, в этой игре реальная.\n" +
              "\n" +
              "Главный герой – Кирито, один из игроков мастеров меча, был бета тестером и неплохо разбирается в игре. По стилю игры он – одиночка. Но самому игру не пройти, надо как-то выкручиваться.",
    "Юи хочет увидеть кита, выполняя подводное задание вместе с Кирито в Alfheim Online. Однако в ходе задания выясняется, что Лифа не умеет плавать. Асуна и другие девушки решают тренировать Сугуху в бассейне в реальном мире.\n" +
            "А в это время Кадзуто кое-кого встречает...",
    "Прошел год после событий первого сезона. К Кирито обращается представитель министерства внутренних дел и коммуникаций с необычной просьбой.\n" +
            "\n" +
            "Речь идет об инцинденте в популярном ММО-шутере Gun Gale Online (сокращенно ГГО). Некто, под именем Death Gun, убивает топовых игроков, в результате чего они умирают и в реальной жизни. Кирито не верит, что такое возможно, но все же соглашается найти в ГГО этого странного стрелка.\n" +
            "\n" +
            "Бродя по миру ГГО, Кирито знакомится с девушкой-снайпером по имени Синон. С ее помощью, в надежде найти парня по имени Death Gun наш герой решает участвовать в большом турнире за звание самого лучшего стрелка ГГО.\n" +
            "\n" +
            "Серия 14.5 - рекап первой части второго сезона.",
    "Полнометражный фильм расскажет о новой игре, для которой требуется устройство расширенной реальности под названием \"Augma\". Игра называется Ordinal Scale и обладает уникальными особенностями, среди которых возможность повышать свой ранг благодаря победам над монстрами и применению предметов. Augma куда компактнее Амусферы. Ordinal Scale - это ARMMORPG, эксклюзивная для Augma. Игра наделала шуму благодаря применению в ней новейших технологий, включающих реальный мир в игру в качестве игрового поля, а также возможности повышать ранг победами над монстрами и применять предметы в различных областях реального мира. Ordinal Scale (OS) - это функция в игре, и все игроки получают ранг, основанный на их порядковых номерах. Таким образом, топовые игроки обладают несокрушимой силой. В соло-PvP порядковый ранг - это важный фактор, определяющий во многом победу и поражение.",
    "Кирито просыпается в гуще огромного, фантастического леса. В попытках разузнать, как он там очутился, он встречает мальчика, который, кажется, знает его. Он должен быть обычным NPC, но его эмоции ничуть не отличаются от человеческих. Со временем к Кирито возвращаются некие воспоминания. Воспоминания из его детства, об этом мальчике и девочке с золотыми, как солнце, волосами, и именем, которое он никогда не должен забыть, — Алиса.",
    "Виртуальный мир «Underworld» - больше не игра для развлечений. Последнее нападение привело к повреждению нервной системы настоящего Кадзуто Киригая. Сбой привел к тому, что его память не заблокировалась и спровоцировала конфликт с собственным виртуальным образом. Всего за несколько часов погружения Кирито проживает внутри игры около двух лет своей альтернативной жизни. Воспоминания обрывочны, а тело обездвижено, сейчас он немощный калека, неспособный говорить. Изгнанница Алиса и ее сестра берут на себя заботу о нем, даже не подозревая, что судьбы этого мира давно предрешены…\n" +
            "\n" +
            "В реальном мире комплекс проекта «Alicization» подвергся нападению неизвестных, все присутствующие отрезаны от внешнего мира. Их последняя надежда – Кирито, чей разум заперт внутри «Underworld». ©Nomia",
    "Карэн всегда чувствовала себя лишней в реальном мире. Из-за своего высокого роста девушке было очень трудно завести подруг среди ровесниц. Но всё изменилось, когда Карэн познакомилась с небезызвестной VRMMORPG — «Gun Gale Online». В мире «GGO» Карэн может сыграть за персонажа своей мечты — невысокую девочку, одетую во всё розовое, аватара её снов. Но сможет ли Карэн найти друзей в этой экшен-игре?"};

    private static String[] fullName = new String[]{
            "Мастера Меча Онлайн - ТВ (25 эп.), адаптация ранобэ, 2012",
            "Мастера Меча Онлайн: Дополнительное издание - ТВ-спэшл, продолжение, 2013",
            "Мастера Меча Онлайн II - ТВ (24 эп.), продолжение, 2014",
            "Мастера Меча Онлайн: Порядковый ранг - п/ф, адаптация ранобэ, 2017",
            "Мастера Меча Онлайн: Алисизация - ТВ (24 эп.), продолжение, 2018",
            "Мастера Меча Онлайн: Алисизация - Война в Подмирье - ТВ (12 эп.), продолжение, 2019",
            "Мастера Меча Онлайн: Альтернативный «GGO» - ТВ (12 эп.), адаптация ранобэ, 2018"
    };

    private static String[] name = new String[]{
      "Мастера Меча Онлайн",
      "Мастера Меча Онлайн: Дополнительное издание",
      "Мастера Меча Онлайн II",
      "Мастера Меча Онлайн: Порядковый ранг",
      "Мастера Меча Онлайн: Алисизация",
      "Мастера Меча Онлайн: Алисизация - Война в Подмирье",
      "Мастера Меча Онлайн: Альтернативный «GGO»"
    };

    private static String director = "Сакой Масаюки";
    private static String language = "UK";

    private static Random random = new Random();

    public static AnimePublication getAnimePublicationFromPublication(Publication publication){
        AnimePublication animePublication = new AnimePublication();
        animePublication.setAccess(RoleEnum.ROLE_GUEST);
        animePublication.setCreateDate(LocalDate.now());
        animePublication.setTypes(publication.getTypes());
        animePublication.setReleaseDateTime(LocalDateTime.now());
        animePublication.setLastUpdateDateTime(LocalDateTime.now());
        animePublication.setName(publication.getName());
        animePublication.setLanguage(publication.getLanguage());
        animePublication.setGenres(publication.getGenres());
        animePublication.setDirector(publication.getDirector());
        animePublication.setDescription(publication.getDescription());
        animePublication.setCategories(publication.getCategories());
        animePublication.setFullName(publication.getFullName());
        return animePublication;
    }
    public static AnimePublication getAnimePublication(int postNumber, CategoriesService categoriesService, TypesService typesService, GenreService genreService){
        return  new AnimePublication(description[postNumber],fullName[postNumber],name[postNumber], director,language,null,
                LocalDate.of(2010,10,20),LocalDateTime.now(),LocalDateTime.now(),
                getTypes("anime",typesService),getCategories(categoriesService),getGenre(genreService),RoleEnum.ROLE_GUEST,random.nextInt(40));
    }

//    public static Publication getAnimePublication(int postNumber, RoleEnum role){
//        Publication publication = getAnimePublication(postNumber);
//        publication.setAccess(role);
//        return publication;
//    }

    private static List<Types> getTypes(String type, TypesService typesService){
        List<Types> types = new ArrayList<>();
        switch (type.toLowerCase()){
            case("anime"):
                types.add(typesService.getById(1L));
                break;
            case("manga"):
                types.add(typesService.getById(2L));
                break;
            case("game"):
                types.add(typesService.getById(3L));
                break;
        }
        return types;
    }
    private static List<Categories> getCategories(CategoriesService categoriesService){
        String[] strCategorie = {"ТВ", "2012", "Драма", "Приключения", "Романтика", "Фэнтези"};
        List<Categories> returnCategories = new ArrayList<>();
            for(int i = 0; i < random.nextInt(10);i++){
                returnCategories.add(categoriesService.getById((long)random.nextInt(strCategorie.length-1)+1));
            }
            return returnCategories;
    }
    private static List<Genre> getGenre(GenreService genreService){
        String[] strGenre = {"приключения", "фэнтези", "романтика", "драма"};
        List<Genre> returnGenres = new ArrayList<>();
            for(int i = 0; i < 6; i++){
            returnGenres.add(genreService.getById((long)random.nextInt(strGenre.length-1)+1));
        }
        return returnGenres;
    }
}
