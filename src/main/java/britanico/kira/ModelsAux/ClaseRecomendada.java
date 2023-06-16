package britanico.kira.ModelsAux;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClaseRecomendada {
    @Id
    public Integer NRO_CLASE;
    public String DESCR_CLASE;
    public String DESCR_CURSO;
    public String SECCION_CLASE;
    public String CICLO_LECTIVO;
    public String SESION;
    public Short VACANTES;
    public BigDecimal PRECIO;
    @ManyToOne
    @JoinColumn(name = "AULA")
    public ModeloReunion MODELO_REUNION;
}
