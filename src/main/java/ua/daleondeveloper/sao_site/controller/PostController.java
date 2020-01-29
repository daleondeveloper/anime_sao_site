package ua.daleondeveloper.sao_site.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.daleondeveloper.sao_site.service.serviceImpl.PostService;
import ua.daleondeveloper.sao_site.service.serviceImpl.VideoService;

@RestController
@AllArgsConstructor
@RequestMapping("/post")
public class PostController {
    private PostService postService;
    private VideoService videoService;

   // html - статичний ресурс, тому ви можете отримати доступ за допомогою "localhost: 8080 / index.html" або використовувати ключове слово "вперед"

    @RequestMapping("/")
    public String index() {
        //has to be without blank spaces
        return "forward:Registration.html";
    }

}
