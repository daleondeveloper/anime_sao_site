package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.dao.publication.GamePublicationRepository;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.GamePublication;

@Service
public class GamePublicationService {

    @Autowired
    private GamePublicationRepository gamePublicationRepository;

    @Transactional
    public GamePublication addPublication(GamePublication publication){
        return gamePublicationRepository.saveAndFlush(publication);}
}
