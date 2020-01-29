package ua.daleondeveloper.sao_site.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.daleondeveloper.sao_site.dao.VideoRepository;

@Service
public class VideoService {
    @Autowired
    VideoRepository videoRepository;
}
