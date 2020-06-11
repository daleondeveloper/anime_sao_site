package ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.utils.GenreRepository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Genre;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Modifying
    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre getById(Long id){
        return genreRepository.getOne(id);
    }

    public Page<Genre> getByTxt(String text){return genreRepository.getByTxt(text);}
}
