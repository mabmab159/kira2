package britanico.kira.Services;

import britanico.kira.DAO.PS_CLASS_TBL_DAO;
import britanico.kira.Models.PS_CLASS_TBL;
import britanico.kira.Models.PS_CLASS_TBL_ID;
import britanico.kira.ModelsAux.ClaseRecomendada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class PS_CLASS_TBL_Service implements PS_CLASS_TBL_DAO {

    @Autowired
    public PS_CLASS_TBL_DAO psClassTblDao;

    @Override
    public List<ClaseRecomendada> clasesRecomendadas(String strm, String session_code, String crse_id, String horario) {
        return psClassTblDao.clasesRecomendadas(strm, session_code, crse_id, horario);
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PS_CLASS_TBL> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PS_CLASS_TBL> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<PS_CLASS_TBL_ID> psClassTblIds) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PS_CLASS_TBL getOne(PS_CLASS_TBL_ID psClassTblId) {
        return null;
    }

    @Override
    public PS_CLASS_TBL getById(PS_CLASS_TBL_ID psClassTblId) {
        return null;
    }

    @Override
    public PS_CLASS_TBL getReferenceById(PS_CLASS_TBL_ID psClassTblId) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PS_CLASS_TBL> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PS_CLASS_TBL> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PS_CLASS_TBL, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PS_CLASS_TBL> List<S> saveAll(Iterable<S> entities) {
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
    public List<PS_CLASS_TBL> findAll() {
        return null;
    }

    @Override
    public List<PS_CLASS_TBL> findAllById(Iterable<PS_CLASS_TBL_ID> psClassTblIds) {
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

    @Override
    public List<PS_CLASS_TBL> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PS_CLASS_TBL> findAll(Pageable pageable) {
        return null;
    }
}
