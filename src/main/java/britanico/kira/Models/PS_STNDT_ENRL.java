package britanico.kira.Models;

import britanico.kira.ModelsAux.UltimaClaseAprobada;
import jakarta.persistence.*;

@NamedNativeQueries(@NamedNativeQuery(name = "PS_STNDT_ENRL.ultimaClaseAprobada",
        query = "SELECT TOP 1 X.CRSE_ID, X.STRM, X.SESSION_CODE, X.CLASS_SECTION, X.CLASS_NBR, X.FEC_FIN_CL, CAST(X" +
                ".FECHA_MAX AS DATE) AS FEC_MAX, CAST(X.FECHA_INSCR AS DATE) AS FEC_INSCR, PAT.STND_MTG_PAT, X" +
                ".EARN_CREDIT FROM (SELECT CT.CRSE_ID, CT.SESSION_CODE, CT.CLASS_SECTION, CT.CLASS_NBR, CT.STRM, " +
                "RE.FEC_FIN_CL, DATEADD(MONTH, CAST(:meses AS INT), CT.END_DT ) AS FECHA_MAX, " +
                "IC.LAST_ENRL_DT_STMP AS FECHA_INSCR, ROW_NUMBER() OVER(ORDER BY CONVERT(INT, CT.STRM) " +
                "DESC, CONVERT(INT, MS.LVF_MES_BRIT) DESC, (LAST_ENRL_DT_STMP + LAST_ENRL_TM_STMP) DESC)" +
                "AS NUM, IC.EARN_CREDIT FROM PS_STDNT_ENRL IC INNER JOIN PS_CLASS_TBL CT ON IC.INSTITUTION =" +
                "CT.INSTITUTION AND IC.ACAD_CAREER = CT.ACAD_CAREER AND IC.STRM=CT.STRM AND IC.SESSION_CODE =" +
                "CT.SESSION_CODE AND IC.CLASS_NBR=CT.CLASS_NBR AND SUBSTRING(CT.SUBJECT ,3 ,LEN(CT.SUBJECT)) IN " +
                "('ADVANC' ,'BASIC' ,'INTERM' ,'JUNIOR' ,'KIDS' ,'PREKID' ,'INFANT') INNER JOIN PS_LVF_TERM_TBL3 " +
                "MS ON MS.INSTITUTION = CT.INSTITUTION AND MS.ACAD_CAREER = CT.ACAD_CAREER AND MS.STRM = CT.STRM " +
                "AND MS.SESSION_CODE = CT.SESSION_CODE INNER JOIN (SELECT CRSE_ID, CRSE_OFFER_NBR, STRM, SESSION_CODE," +
                "CLASS_SECTION, MAX(END_DT) AS FEC_FIN_CL FROM PS_CLASS_MTG_PAT GROUP BY CRSE_ID, CRSE_OFFER_NBR," +
                "STRM, SESSION_CODE, CLASS_SECTION) RE ON RE.CRSE_ID = CT.CRSE_ID AND RE.CRSE_OFFER_NBR = CT.CRSE_OFFER_NBR " +
                "AND RE.STRM = CT.STRM AND RE.SESSION_CODE = CT.SESSION_CODE AND RE.CLASS_SECTION = CT.CLASS_SECTION " +
                "INNER JOIN PS_CRSE_CATALOG CC ON CC.CRSE_ID = RE.CRSE_ID AND CC.EFFDT = (SELECT MAX(B_ED.EFFDT) FROM" +
                " PS_CRSE_CATALOG B_ED WHERE CC.CRSE_ID = B_ED.CRSE_ID AND B_ED.EFFDT <= GETDATE()) AND CC" +
                ".RQMNT_DESIGNTN='' WHERE IC.EMPLID = :emplid AND IC.STDNT_ENRL_STATUS = 'E' AND IC.CRSE_GRADE_INPUT " +
                "<> ' ') X INNER JOIN PS_CLASS_MTG_PAT PAT ON X.CRSE_ID = PAT.CRSE_ID " +
                "AND X.STRM = PAT.STRM AND X.CLASS_SECTION = PAT.CLASS_SECTION AND X.SESSION_CODE = PAT.SESSION_CODE " +
                "WHERE X.NUM = 1", resultSetMapping = "ModelsAux.UltimaClaseAprobada")
        //,
        //@NamedNativeQuery(name = "", query = "", resultSetMapping = "")
)
@SqlResultSetMappings(@SqlResultSetMapping(name = "ModelsAux.UltimaClaseAprobada",
        classes = @ConstructorResult(targetClass = UltimaClaseAprobada.class,
                columns = {@ColumnResult(name = "CRSE_ID"), @ColumnResult(name = "STRM"),
                        @ColumnResult(name = "SESSION_CODE"), @ColumnResult(name = "CLASS_SECTION"),
                        @ColumnResult(name = "CLASS_NBR"), @ColumnResult(name = "FEC_FIN_CL"),
                        @ColumnResult(name = "FEC_MAX"), @ColumnResult(name = "FEC_INSCR"),
                        @ColumnResult(name = "STND_MTG_PAT"), @ColumnResult(name = "EARN_CREDIT")}))
        //, @SqlResultSetMapping(name = "",
        //classes = @ConstructorResult(targetClass = Object.class, columns = {@ColumnResult(name = "")}))
)
@Entity
@Table(name = "PS_STNDT_ENRL")
public class PS_STNDT_ENRL {
    @EmbeddedId
    public PS_CLASS_TBL_ID psClassTblId;
    public int CLASS_NBR;
    public String CAMPUS_EVENT_NBR;
    public String SUBJECT;
    public String CATALOG_NBR;
    public String INSTITUTION;
    public String ACAD_CAREER;
    public int ENRL_CAP;
    public int ENRL_TOT;
}
