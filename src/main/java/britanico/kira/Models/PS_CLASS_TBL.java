package britanico.kira.Models;

import britanico.kira.ModelsAux.ClaseRecomendada;
import jakarta.persistence.*;

@NamedNativeQueries({@NamedNativeQuery(name = "PS_CLASS_TBL.clasesRecomendadas",
        query = "SELECT A.CLASS_NBR AS NRO_CLASE, D.DESCR AS DESCR_CLASE, D.COURSE_TITLE_LONG AS DESCR_CURSO, A" +
                ".CLASS_SECTION AS SECCION_CLASE, A.STRM AS CICLO_LECTIVO, A.SESSION_CODE AS SESION, A.WAIT_CAP AS " +
                "VACANTES, C.ITEM_AMT AS PRECIO, B.MON, B.TUES, B.WED, B.THURS, B.FRI, B.SAT, B.SUN, B.STND_MTG_PAT " +
                "AS COD_HORA, B.FACILITY_ID AS AULA FROM PS_CLASS_TBL A INNER JOIN PS_CLASS_MTG_PAT B ON (A" +
                ".SESSION_CODE = B.SESSION_CODE AND A.STRM = B.STRM AND A.CRSE_OFFER_NBR = B.CRSE_OFFER_NBR AND A" +
                ".CLASS_SECTION = B.CLASS_SECTION AND A.CRSE_ID = B.CRSE_ID) INNER JOIN PS_LVF_PLNT_FEECL2 C ON (A" +
                ".STRM = C.STRM AND A.SESSION_CODE = C.SESSION_CODE AND A.CRSE_ID = C.CRSE_ID) INNER JOIN " +
                "PS_CRSE_CATALOG D ON (A.CRSE_ID = D.CRSE_ID) WHERE A.STRM = :strm AND A.SESSION_CODE = :session_code" +
                " AND A.CRSE_ID = (SELECT CRSE_ID_EXT FROM PS_BRT_MAPCRSE_TBL WHERE CRSE_ID = :crse_id AND " +
                "BRT_CRSE_RECOMEND = 'Y') AND B.STND_MTG_PAT = :horario",
        resultSetMapping = "ClaseRecomendadaDTOWithModeloReunion")})
@SqlResultSetMapping(name = "ClaseRecomendadaDTOWithModeloReunion", classes = {
        @ConstructorResult(targetClass = ClaseRecomendada.class,
                columns = {@ColumnResult(name = "NRO_CLASE"), @ColumnResult(name = "DESCR_CLASE"),
                        @ColumnResult(name = "DESCR_CURSO"), @ColumnResult(name = "SECCION_CLASE"),
                        @ColumnResult(name = "CICLO_LECTIVO"), @ColumnResult(name = "SESION"),
                        @ColumnResult(name = "VACANTES"), @ColumnResult(name = "PRECIO"), @ColumnResult(name = "AULA"),
                        @ColumnResult(name = "MON"), @ColumnResult(name = "TUES"), @ColumnResult(name = "WED"),
                        @ColumnResult(name = "THURS"), @ColumnResult(name = "FRI"), @ColumnResult(name = "SAT"),
                        @ColumnResult(name = "SUN")})})
@Entity
@Table(name = "PS_CLASS_TBL")
public class PS_CLASS_TBL {
    @EmbeddedId
    public PS_CLASS_TBL_ID psClassTblId;
}
