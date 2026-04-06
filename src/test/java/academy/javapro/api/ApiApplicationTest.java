package academy.javapro.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ApiApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void springContextLoads() {
        // Passes if Spring Boot starts without errors
    }

    @Test
    void serverResponds() throws Exception {
        // No controllers yet — 404 is correct and expected
        mockMvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
    }
}