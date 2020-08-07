package ua.daleondeveloper.sao_site.dao.dynamicDAO;

import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;

public class PublicationDynamicRepositoryImpl implements PublicationDynamicRepository{

    @PersistenceContext
    private EntityManager em;

    public void updatePublication(Publication reqPub){
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaUpdate update = cb.createCriteriaUpdate(Publication.class);

        Root e = update.from(Publication.class);

        if(reqPub instanceof AnimePublication){
            update  = cb.createCriteriaUpdate(AnimePublication.class);
            e = update.from(AnimePublication.class);
            AnimePublication animePublication = (AnimePublication)reqPub;
            if(animePublication.getCountSeries() > 0){
                update.set("countSeries", animePublication.getCountSeries());
            }
        }

        if(reqPub.getName() != null && !reqPub.getName().isEmpty()) {
            update.set("name", reqPub.getName());
        }
        if(reqPub.getFullName() != null && !reqPub.getFullName().isEmpty()) {
            update.set("fullName", reqPub.getFullName());
        }
        if(reqPub.getDescription() != null && !reqPub.getDescription().isEmpty()) {
            update.set("description", reqPub.getDescription());
        }
        if(reqPub.getDirector() != null && !reqPub.getDirector().isEmpty()) {
            update.set("director", reqPub.getDirector());
        }
        if(reqPub.getLanguage() != null && !reqPub.getLanguage().isEmpty()) {
            update.set("language", reqPub.getLanguage());
        }

            update.set("lastUpdateDateTime", LocalDateTime.now());



        update.where(cb.equal(e.get("id"),reqPub.getId()));

        this.em.createQuery(update).executeUpdate();
    }
}
