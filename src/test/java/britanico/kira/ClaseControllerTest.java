package britanico.kira;

import britanico.kira.Controller.ClaseController;
import britanico.kira.DAO.PS_CLASS_TBL_DAO;
import britanico.kira.ModelsAux.ClaseRecomendada;
import britanico.kira.ModelsAux.Salida;
import britanico.kira.Services.PS_CLASS_TBL_Service;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
public class ClaseControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public ClaseController psClassTblService;

    @Test
    public void obtenerClaseRecomendada() throws Exception {
        when(psClassTblService.obtenerRecomendacion("369564")).thenReturn(Salida.builder().body(Salida.Body.builder()
                .data(List.of(new ClaseRecomendada(17964, "B03", "BASIC 03", "3", "2023", "FDS", (short) 0,
                        new BigDecimal("270.00")))).build()).build());
        mockMvc.perform(MockMvcRequestBuilders.get("/clase/claseRecomendada/369564"))
                .andExpect(status().is3xxRedirection());
    }
}
