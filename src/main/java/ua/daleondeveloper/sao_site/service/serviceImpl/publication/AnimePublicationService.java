package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.daleondeveloper.sao_site.dao.publication.AnimePublicationRepository;
import ua.daleondeveloper.sao_site.domain.Files.ImagePublication;
import ua.daleondeveloper.sao_site.domain.publication.AnimePublication;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnimePublicationService {

    @Autowired
    private AnimePublicationRepository animePublicationRepository;

    public Long getCount(){return animePublicationRepository.count();}

    public Page<AnimePublication> getAnimeByNumber(int start, int end){
        return animePublicationRepository.findAll(PageRequest.of(start,end,Sort.by(Sort.Direction.DESC, "lastUpdateDateTime")));
    }
    public List<ImagePublication> getInfoImages(Long id){
        AnimePublication animePublication = animePublicationRepository.findById(id).get();
        return animePublication.getInfoImages();
    }
//,Sort.by(Sort.Direction.DESC, "lastUpdateDateTime")
    @Transactional
    public AnimePublication addPublication(AnimePublication publication){
        publication.setCreateDate(LocalDate.now());
        publication.setLastUpdateDateTime(LocalDateTime.now());
        publication.setReleaseDateTime(LocalDateTime.now());
        return animePublicationRepository.saveAndFlush(publication);
    }

    @Transactional
    public AnimePublication addInfoImage(Long publicationId, ImagePublication infoImage){
        AnimePublication animePublication = animePublicationRepository.findById(publicationId).get();
        animePublication.getInfoImages().add(infoImage);
        animePublicationRepository.flush();
        return animePublication;

    }

}
