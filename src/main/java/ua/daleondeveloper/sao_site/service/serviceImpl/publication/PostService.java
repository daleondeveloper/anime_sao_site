package ua.daleondeveloper.sao_site.service.serviceImpl.publication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.PublicationRepository;

@Service
public class PostService {
    @Autowired
    private PublicationRepository publicationRepository;
}
