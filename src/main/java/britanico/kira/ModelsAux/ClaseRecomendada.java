package britanico.kira.ModelsAux;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AULA", referencedColumnName = "AULA")
    public ModeloReunion MODELO_REUNION;
}
