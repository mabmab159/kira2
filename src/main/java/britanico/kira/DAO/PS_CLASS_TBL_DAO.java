package britanico.kira.DAO;

import britanico.kira.Models.PS_CLASS_TBL;
import britanico.kira.Models.PS_CLASS_TBL_ID;
import britanico.kira.ModelsAux.ClaseRecomendada;
import britanico.kira.ModelsAux.HistorialClases;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PS_CLASS_TBL_DAO extends CrudRepository<PS_CLASS_TBL, PS_CLASS_TBL_ID> {

    @Query(nativeQuery = true)
    List<ClaseRecomendada> clasesRecomendadas(@Param("strm") String strm, @Param("session_code") String session_code,
                                              @Param("crse_id") String crse_id, @Param("horario") String horario);

    @Query(nativeQuery = true)
    List<HistorialClases> historialClases(@Param("emplid") String emplid);
}
