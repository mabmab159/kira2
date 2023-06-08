package britanico.kira.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "PS_LVF_PARAM_GENER")
public class PS_LVF_PARAM_GENER {
    @EmbeddedId
    public PS_LVF_PARAM_GENER_ID psLvfParamGenerId;
    public String LVF_PARAM_VALUE;
    public String DESCR254;
}
