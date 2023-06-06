package britanico.kira.Models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PS_STDNT_ENRL_ID implements Serializable {
    public String EMPLID;
    public String ACAD_CAREER;
    public String INSTITUTION;
    public String STRM;
    public int CLASS_NBR;
}
