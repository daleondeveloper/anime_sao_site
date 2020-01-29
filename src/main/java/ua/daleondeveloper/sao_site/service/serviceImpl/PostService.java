package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.PostRepository;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
}
