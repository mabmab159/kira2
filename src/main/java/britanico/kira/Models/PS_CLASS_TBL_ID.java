package britanico.kira.Models;

import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class PS_CLASS_TBL_ID implements Serializable {
    public String CRSE_ID;
    public int CRSE_OFFER_NBR;
    public String STRM;
    public String SESSION_CODE;
    public String CLASS_SECTION;
}