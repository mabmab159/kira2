package britanico.kira.ModelsAux;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ModeloReunion {
    @Id
    public String AULA;
    public String COD_HORA;
    

}
