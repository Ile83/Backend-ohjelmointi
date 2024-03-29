package fi.heusala.Bookstore;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class BookRestTests {

    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mockMvc;

    @BeforeEach

    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

    }

    @Test
    public void statusOk() throws Exception {
        mockMvc.perform(get("/books")).andExpect(status().isOk());
    }

    @Test
    public void responseTypes() throws Exception {
        mockMvc.perform(get("/books")).andExpect(content().contentType(MediaType.APPLICATION_JSON))
                // .andExpect(content().contentType(MeadiaType.APPLICATION_ATOM_XML_VALUE))
                .andExpect(status().isOk());
    }

    // @Test
    // public void apiStatusOk() throws Exception {
    // mockMvc.perform(get("/api/books")).andExpect(status().isOk());
    // }

}
