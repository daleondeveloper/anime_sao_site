package ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.utils.TypesRepository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Types;

@Service
public class TypesService {

    @Autowired
    private TypesRepository typesRepository;

    @Modifying
    public Types save(Types types){
        return typesRepository.save(types);
    }

    public Types getById(Long id){
        return typesRepository.getOne(id);
    }
}
