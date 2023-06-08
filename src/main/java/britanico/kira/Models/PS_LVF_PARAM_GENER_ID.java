package britanico.kira.Models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PS_LVF_PARAM_GENER_ID implements Serializable {
    public String SETID;
    public String BUSINESS_UNIT;
    public String LVF_PARAM_ID;
}