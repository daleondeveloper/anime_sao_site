package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.AnimePublicationRepository;

@Service
public class AnimePublicationService {

    @Autowired
    private AnimePublicationRepository animePublicationRepository;
}
