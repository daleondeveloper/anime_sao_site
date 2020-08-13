package ua.daleondeveloper.sao_site;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ua.daleondeveloper.sao_site.controller.LinkController;
import ua.daleondeveloper.sao_site.domain.publication.Publication;


import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class SaoSiteApplicationTests {

    @LocalServerPort
    private int port;
    @Autowired
    private LinkController linkController;
    @Autowired
    private TestRestTemplate testRestTemplate;
   @Autowired
   private MockMvc mockMvc;

    @Test
    void contextLoads() throws Exception{
        assertThat(linkController).isNotNull();

    }
    @Test
    public void secondTest() throws Exception{
//        assertThat(this.testRestTemplate.getForObject("http://localhost:" + port + "/api/v1/publication/20",
//                ResponseEntity.class)).isEqualTo(0L);
        MvcResult mvcResult = mockMvc.perform(
                get("http://localhost:" + port + "/api/v1/publication/200")
                .accept(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("20"))
                .andReturn();
        String content = mvcResult.getResponse().getContentType();
        System.out.println(content);
    }

}
