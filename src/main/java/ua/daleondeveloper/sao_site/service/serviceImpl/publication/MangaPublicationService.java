package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.dao.publication.GamePublicationRepository;
import ua.daleondeveloper.sao_site.dao.publication.MangaPiblicationRepository;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.MangaPublication;

@Service
public class MangaPublicationService {

    @Autowired
    private MangaPiblicationRepository mangaPublicationRepository;

    @Transactional
    public MangaPublication addPublication(MangaPublication publication){
        return mangaPublicationRepository.saveAndFlush(publication);}
}
