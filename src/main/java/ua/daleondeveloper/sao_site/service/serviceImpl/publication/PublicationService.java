package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
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

    //find publication in BD by updatePublication.id then insert
    //to BD entity new date from updatePublication
    @Transactional
    public Publication merge(Publication updatePublication){
        Optional<Publication> publicationBDOptional = findById(updatePublication.getId());
        if(publicationBDOptional.isPresent()){
            Publication publicationBD = publicationBDOptional.get();
            publicationBD.merge(updatePublication);
            return publicationRepository.updatePublication(publicationBD);

        }else{
            //not found
        }
        return null;
    }
}
