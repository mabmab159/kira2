package britanico.kira.ModelsAux;

import jakarta.persistence.Table;

import java.util.Date;

@Table
public class UltimaClaseAprobada {
    public String CRSE_ID; //Curso aprobado
    public String STRM;
    public String SESSION_CODE;
    public String CLASS_SECTION;
    public Integer CLASS_NBR;
    public Date FEC_FIN_CL; //Fin de curso aprobado
    public Date FEC_MAX; //Fecha max para aprobar el siguiente curso
    public Date FEC_INSCR; //Fecha de inscripcion al ultimo curso aprobado
    public String STND_MTG_PAT; // Horario de la ultima clase aprobada
    public Character EARN_CREDIT; //Estado del curso tomado
}
