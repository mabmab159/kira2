package britanico.kira.DAO;

import britanico.kira.Models.PS_LVF_PARAM_GENER;
import britanico.kira.Models.PS_LVF_PARAM_GENER_ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PS_LVF_PARAM_GENER_DAO extends JpaRepository<PS_LVF_PARAM_GENER, PS_LVF_PARAM_GENER_ID> {
    @Query("SELECT P.LVF_PARAM_VALUE FROM PS_LVF_PARAM_GENER P WHERE P.psLvfParamGenerId.LVF_PARAM_ID = 'BRT_MESES_DISCONTINUIDAD'")
    String obtenerCantidadMesesContinuidad();
}
