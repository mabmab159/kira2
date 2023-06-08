package britanico.kira.Services;

import britanico.kira.DAO.PS_LVF_PARAM_GENER_DAO;
import britanico.kira.Models.PS_LVF_PARAM_GENER;
import britanico.kira.Models.PS_LVF_PARAM_GENER_ID;
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
public class PS_LVF_PARAM_GENER_Service implements PS_LVF_PARAM_GENER_DAO {
    @Override
    public String obtenerCantidadMesesContinuidad() {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<PS_LVF_PARAM_GENER> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<PS_LVF_PARAM_GENER_ID> psLvfParamGenerIds) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PS_LVF_PARAM_GENER getOne(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {
        return null;
    }

    @Override
    public PS_LVF_PARAM_GENER getById(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {
        return null;
    }

    @Override
    public PS_LVF_PARAM_GENER getReferenceById(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER, R> R findBy(Example<S> example,
                                                      Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> S save(S entity) {
        return null;
    }

    @Override
    public <S extends PS_LVF_PARAM_GENER> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<PS_LVF_PARAM_GENER> findById(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {
        return false;
    }

    @Override
    public List<PS_LVF_PARAM_GENER> findAll() {
        return null;
    }

    @Override
    public List<PS_LVF_PARAM_GENER> findAllById(Iterable<PS_LVF_PARAM_GENER_ID> psLvfParamGenerIds) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(PS_LVF_PARAM_GENER_ID psLvfParamGenerId) {

    }

    @Override
    public void delete(PS_LVF_PARAM_GENER entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends PS_LVF_PARAM_GENER_ID> psLvfParamGenerIds) {

    }

    @Override
    public void deleteAll(Iterable<? extends PS_LVF_PARAM_GENER> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<PS_LVF_PARAM_GENER> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PS_LVF_PARAM_GENER> findAll(Pageable pageable) {
        return null;
    }
}
