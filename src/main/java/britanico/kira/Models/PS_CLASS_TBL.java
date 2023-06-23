package britanico.kira.Models;

import britanico.kira.ModelsAux.ClaseRecomendada;
import britanico.kira.ModelsAux.HistorialClases;
import jakarta.persistence.*;

@NamedNativeQuery(name = "PS_CLASS_TBL.clasesRecomendadas",
        query = "SELECT I.XLATLONGNAME AS DESC_FREC, I.FIELDVALUE AS COD_FREC, G.NAME AS DOCENTE, " +
                "(CONVERT(VARCHAR, B.MEETING_TIME_START,108)+' - '+CONVERT(VARCHAR,B" +
                ".MEETING_TIME_END, 108)) AS DESC_HORA, F.DESCR AS DESC_UBI, A.LOCATION AS COD_UBI, " +
                "(CONVERT(VARCHAR,E.SESS_BEGIN_DT,103)+' - '+ CONVERT(VARCHAR,E.SESS_END_DT,103)) AS " +
                "FECHAS_CLASE, A.CLASS_NBR AS NRO_CLASE, D.DESCR AS DESCR_CLASE, D.COURSE_TITLE_LONG " +
                "AS DESCR_CURSO, A.CLASS_SECTION AS SECCION_CLASE, A.STRM AS CICLO_LECTIVO, A" +
                ".SESSION_CODE AS SESION, A.WAIT_CAP AS " +
                "VACANTES, C.ITEM_AMT AS PRECIO, B.MON, B.TUES, B.WED, B.THURS, B.FRI, B.SAT, B.SUN, B.STND_MTG_PAT " +
                "AS COD_HORA, B.FACILITY_ID AS AULA FROM PS_CLASS_TBL A INNER JOIN PS_CLASS_MTG_PAT B ON (A" +
                ".SESSION_CODE = B.SESSION_CODE AND A.STRM = B.STRM AND A.CRSE_OFFER_NBR = B.CRSE_OFFER_NBR AND A" +
                ".CLASS_SECTION = B.CLASS_SECTION AND A.CRSE_ID = B.CRSE_ID) INNER JOIN PS_LVF_PLNT_FEECL2 C ON (A" +
                ".STRM = C.STRM AND A.SESSION_CODE = C.SESSION_CODE AND A.CRSE_ID = C.CRSE_ID) INNER JOIN " +
                "PS_CRSE_CATALOG D ON (A.CRSE_ID = D.CRSE_ID) INNER JOIN PS_SESSION_TBL E ON (A.STRM = E.STRM AND A" +
                ".SESSION_CODE = E.SESSION_CODE) INNER JOIN PS_LOCATION_TBL F ON (A.LOCATION = F.LOCATION) INNER JOIN" +
                " PS_PERSONAL_DATA G ON (A.EMPLID = G.EMPLID) INNER JOIN PS_LVF_TERM_TBL3 H ON (A.STRM = H.STRM AND A" +
                ".SESSION_CODE = H.SESSION_CODE) INNER JOIN PSXLATITEM I ON (I.FIELDVALUE = H.LVF_TURNO_IDT)WHERE A" +
                ".STRM = :strm AND A.SESSION_CODE = :session_code AND A.CRSE_ID = (SELECT CRSE_ID_EXT FROM " +
                "PS_BRT_MAPCRSE_TBL WHERE CRSE_ID = :crse_id AND " +
                "BRT_CRSE_RECOMEND = 'Y') AND B.STND_MTG_PAT = :horario AND I.FIELDNAME='LVF_TURNO_IDT'",
        resultSetMapping = "PS_CLASS_TBL.clasesRecomendadas")
@NamedNativeQuery(name = "PS_CLASS_TBL.historialClases",
        query = "SELECT A.EMPLID, A.STRM, A.INSTITUTION, A.CRSE_CAREER, A.SESSION_CODE, A.CLASS_NBR, A.CRSE_GRADE_INPUT, A.ACAD_PROG," +
                " A.GRADE_DT, A.GRADING_BASIS_ENRL, B.LVF_MES_BRIT, B.LOCATION, C.CRSE_ID, C.EMPLID AS DOCENTE_CODIGO " +
                "FROM PS_STDNT_ENRL A \n" +
                "\t, PS_LVF_TERM_TBL3 B \n" +
                "\t, PS_CLASS_TBL C \n" +
                "\t, PS_CLASS_MTG_PAT D \n" +
                ", PS_LOCATION_TBL E"+
                "WHERE A.INSTITUTION = B.INSTITUTION \n" +
                "\tAND A.ACAD_CAREER =  B.ACAD_CAREER\n" +
                "    AND A.STRM = B.STRM \n" +
                "\tAND A.SESSION_CODE = B.SESSION_CODE\n" +
                "\tAND A.INSTITUTION = C.INSTITUTION\n" +
                "\tAND A.STRM = C.STRM \n" +
                "\tAND A.CLASS_NBR = C.CLASS_NBR\n" +
                "\tAND A.SESSION_CODE = C.SESSION_CODE \n" +
                "\tAND C.CRSE_ID = D.CRSE_ID\n" +
                "\tAND C.CRSE_OFFER_NBR = D.CRSE_OFFER_NBR \n" +
                "\tAND C.STRM = D.STRM \n" +
                "\tAND C.SESSION_CODE = D.SESSION_CODE\n" +
                "\tAND C.CLASS_SECTION = D.CLASS_SECTION \n" +
                "\tAND D.CLASS_MTG_NBR = (\n" +
                "\t\t\t\t\t\t\t\tSELECT MIN(X.CLASS_MTG_NBR)\n" +
                "\t\t\t\t\t\t\t\tFROM PS_CLASS_MTG_PAT X\n" +
                "\t\t\t\t\t\t\t\tWHERE  X.CRSE_ID = D.CRSE_ID\n" +
                "\t\t\t\t\t\t\t\t\t\tAND X.CRSE_OFFER_NBR = D.CRSE_OFFER_NBR \n" +
                "\t\t\t\t\t\t\t\t\t\tAND X.STRM = D.STRM \n" +
                "\t\t\t\t\t\t\t\t\t\tAND X.SESSION_CODE = D.SESSION_CODE\n" +
                "\t\t\t\t\t\t\t\t\t\tAND X.CLASS_SECTION = D.CLASS_SECTION)\n" +
                "AND B.LOCATION = E.LOCATION"+
                "\tAND A.EMPLID=:emplid AND A.ENRL_STATUS_REASON='ENRL' ORDER BY A.GRADE_DT DESC",
        resultSetMapping = "PS_CLASS_TBL.historialClases")
@SqlResultSetMapping(name = "PS_CLASS_TBL.clasesRecomendadas", classes = {
        @ConstructorResult(targetClass = ClaseRecomendada.class,
                columns = {@ColumnResult(name = "NRO_CLASE"), @ColumnResult(name = "DESCR_CLASE"),
                        @ColumnResult(name = "DOCENTE"), @ColumnResult(name = "DESC_UBI"),
                        @ColumnResult(name = "COD_FREC"), @ColumnResult(name = "DESC_FREC"),
                        @ColumnResult(name = "COD_UBI"), @ColumnResult(name = "DESC_HORA"),
                        @ColumnResult(name = "FECHAS_CLASE"), @ColumnResult(name = "DESCR_CURSO"),
                        @ColumnResult(name = "SECCION_CLASE"), @ColumnResult(name = "CICLO_LECTIVO"),
                        @ColumnResult(name = "SESION"), @ColumnResult(name = "VACANTES"),
                        @ColumnResult(name = "PRECIO"), @ColumnResult(name = "AULA"), @ColumnResult(name = "COD_HORA"),
                        @ColumnResult(name = "MON"), @ColumnResult(name = "TUES"), @ColumnResult(name = "WED"),
                        @ColumnResult(name = "THURS"), @ColumnResult(name = "FRI"), @ColumnResult(name = "SAT"),
                        @ColumnResult(name = "SUN")})})
@SqlResultSetMapping(name = "PS_CLASS_TBL.historialClases", classes = {
        @ConstructorResult(targetClass = HistorialClases.class,
                columns = {@ColumnResult(name = "EMPLID"), @ColumnResult(name = "STRM"),
                        @ColumnResult(name = "INSTITUTION"), @ColumnResult(name = "CRSE_CAREER"),
                        @ColumnResult(name = "SESSION_CODE"), @ColumnResult(name = "LVF_MES_BRIT"),
                        @ColumnResult(name = "ACAD_PROG"), @ColumnResult(name = "CLASS_NBR"),
                        @ColumnResult(name = "LOCATION"),
                        @ColumnResult(name = "CRSE_ID"),
                        @ColumnResult(name = "DOCENTE_CODIGO"),
                        @ColumnResult(name = "CRSE_GRADE_INPUT"), @ColumnResult(name = "GRADE_DT"),
                        @ColumnResult(name = "GRADING_BASIS_ENRL")

                })})

@Entity
@Table(name = "PS_CLASS_TBL")
public class PS_CLASS_TBL {
    @EmbeddedId
    public PS_CLASS_TBL_ID psClassTblId;
}
