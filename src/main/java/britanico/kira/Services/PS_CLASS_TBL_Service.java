package britanico.kira.Services;

import britanico.kira.DAO.PS_CLASS_TBL_DAO;
import britanico.kira.Models.PS_CLASS_TBL;
import britanico.kira.Models.PS_CLASS_TBL_ID;
import britanico.kira.ModelsAux.ClaseRecomendada;
import britanico.kira.ModelsAux.HistorialClases;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Optional;

@Service
public class PS_CLASS_TBL_Service implements PS_CLASS_TBL_DAO {
    public PS_CLASS_TBL_DAO psClassTblDao;

    public PS_CLASS_TBL_Service(PS_CLASS_TBL_DAO psClassTblDao) {
        this.psClassTblDao = psClassTblDao;
    }

    @Override
    public List<ClaseRecomendada> clasesRecomendadas(String strm, String session_code, String crse_id, String horario) {
        return psClassTblDao.clasesRecomendadas(strm, session_code, crse_id, horario);
    }

    @Override
    public List<HistorialClases> historialClases(String crse_id) {
        return psClassTblDao.historialClases(crse_id);
    }

    @Override
    public <S extends PS_CLASS_TBL> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PS_CLASS_TBL> findById(PS_CLASS_TBL_ID psClassTblId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(PS_CLASS_TBL_ID psClassTblId) {
        return false;
    }

    @Override
    public Iterable<PS_CLASS_TBL> findAll() {
        return null;
    }

    @Override
    public Iterable<PS_CLASS_TBL> findAllById(Iterable<PS_CLASS_TBL_ID> psClassTblIds) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(PS_CLASS_TBL_ID psClassTblId) {

    }

    @Override
    public void delete(PS_CLASS_TBL entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends PS_CLASS_TBL_ID> psClassTblIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends PS_CLASS_TBL> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
