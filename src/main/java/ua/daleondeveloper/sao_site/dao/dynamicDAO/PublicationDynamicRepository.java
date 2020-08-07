package ua.daleondeveloper.sao_site.dao.dynamicDAO;

import ua.daleondeveloper.sao_site.domain.publication.Publication;
import ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils.GenreService;

public interface PublicationDynamicRepository {
    void updatePublication(Publication publication, GenreService genreService);
}
