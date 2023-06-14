package britanico.kira.ModelsAux;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "DIAS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dias {
    @Id
    public String AULA;
    public String MON;
    public String TUES;
    public String WED;
    public String THURS;
    public String FRI;
    public String SAT;
    public String SUN;

}
