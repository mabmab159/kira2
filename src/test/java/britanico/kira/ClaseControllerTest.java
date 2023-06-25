package britanico.kira;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ClaseControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void validarClaseRecomendada() throws Exception {
        this.mockMvc.perform(get("/clase/historialClases/369564")).andExpect(status().isOk());
    }

    @Test
    public void validarClaseRecomendada2() throws Exception {
        this.mockMvc.perform(get("/clase/historialClases/")).andExpect(status().is4xxClientError());
    }

    @Test
    public void validarTest() throws Exception {
        this.mockMvc.perform(get("/clase/test")).andExpect(content().string("Hello "));
    }

    @Test
    public void validarTest2() throws Exception {
        this.mockMvc.perform(get("/clase/claseRecomendada/369564").contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.success", is(1)))
                .andExpect(jsonPath("$.body.data.[0].NRO_CLASE", is(instanceOf(Integer.class))))
                .andExpect(jsonPath("$.body.data", hasSize(3)))
        ;
    }

}
