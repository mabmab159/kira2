package britanico.kira.DAO;

import britanico.kira.Models.PS_STDNT_ENRL_ID;
import britanico.kira.Models.PS_STNDT_ENRL;
import britanico.kira.ModelsAux.UltimaClaseAprobada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PS_STDNT_ENRL_DAO extends JpaRepository<PS_STNDT_ENRL, PS_STDNT_ENRL_ID> {

    @Query(nativeQuery = true)
    UltimaClaseAprobada ultimaClaseAprobada(@Param("institution") String institution, @Param("emplid") String emplid,
                                            @Param("meses") String meses);
}
