package britanico.kira.ModelsAux;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
public class ClaseRecomendada {
    public Integer NRO_CLASE;
    public String DESCR_CLASE;
    public String DESCR_CURSO;
    public String SECCION_CLASE;
    public String CICLO_LECTIVO;
    public String SESION;
    public Short VACANTES;
    public BigDecimal PRECIO;

}
