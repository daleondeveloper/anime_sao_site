package ua.daleondeveloper.sao_site.service.serviceImpl.publication.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.publication.utils.CategoriesRepository;
import ua.daleondeveloper.sao_site.domain.publication.utils.Categories;

import java.util.List;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Modifying
    public Categories save(Categories categories){
        return categoriesRepository.save(categories);
    }

    public Categories getById(Long id){
        return categoriesRepository.getOne(id);
    }

    public List<Categories> getByTxt(String text){return categoriesRepository.getCategoriesTxt(text);}

}
