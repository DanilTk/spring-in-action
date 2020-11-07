package pl.dan.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.dan.demo.controller.WebConfig;

import static org.hamcrest.Matchers.containsString;


@WebMvcTest(WebConfig.class)
class WebConfigTest {
    @Autowired
    MockMvc mvc;

    //    @Test
    void testHome() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("home"))
                .andExpect(MockMvcResultMatchers.content().string(containsString("Welcome to...")));
    }
}