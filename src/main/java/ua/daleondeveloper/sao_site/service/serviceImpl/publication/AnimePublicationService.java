package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.AnimePublicationRepository;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;

@Service
public class AnimePublicationService {

    @Autowired
    private AnimePublicationRepository animePublicationRepository;

    public Long getCount(){return animePublicationRepository.count();}

    public Page<AnimePublication> getAnimeByNumber(int start, int end){
        return animePublicationRepository.findAll(PageRequest.of(start,end));
    }
}
