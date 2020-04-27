package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.PublicationRepository;
import ua.daleondeveloper.sao_site.domain.publication.Publication;

import java.util.Optional;

@Service
public class PublicationService {
    @Autowired
    private PublicationRepository publicationRepository;

    public Long getCountPublication(){return publicationRepository.count();}

    public Page<Publication> getPublicationByNumber(int start, int end){
        return publicationRepository.findAll(PageRequest.of(start,end));
    }
    public Optional<Publication> findById(Long id){return publicationRepository.findById(id);}
}
