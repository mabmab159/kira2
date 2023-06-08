package britanico.kira.Controller;

import britanico.kira.ModelsAux.ClaseRecomendada;
import britanico.kira.ModelsAux.UltimaClaseAprobada;
import britanico.kira.Services.PS_CLASS_TBL_Service;
import britanico.kira.Services.PS_STDNT_ENRL_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

@RestController
public class PS_STDNT_ENRL_Controller {

    public PS_STDNT_ENRL_Service psStdntEnrlService;
    public PS_CLASS_TBL_Service psClassTblService;

    @Autowired
    public PS_STDNT_ENRL_Controller(PS_STDNT_ENRL_Service psStdntEnrlService, PS_CLASS_TBL_Service psClassTblService) {
        this.psStdntEnrlService = psStdntEnrlService;
        this.psClassTblService = psClassTblService;
    }

    @GetMapping("/test/{institution}/{emplid}")
    public ResponseEntity<Object> obtenerRecomendacion(@PathVariable("institution") String institution,
                                                       @PathVariable("emplid") String emplid) {
        UltimaClaseAprobada ultimaClaseAprobada = psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6");
        LocalDate fechaActual = LocalDate.now();
        /*if (ultimaClaseAprobada.FEC_MAX.after(
                Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            String sesionRecomendar =
                    (char) (fechaActual.getMonthValue() + 64) + ultimaClaseAprobada.SESSION_CODE.substring(1);
            return new ResponseEntity<>(
                    psClassTblService.clasesRecomendadas("2023", sesionRecomendar, ultimaClaseAprobada.CRSE_ID,
                            ultimaClaseAprobada.STND_MTG_PAT), HttpStatus.OK);
        } else {
            //No considerar curso a retornar puesto que ya supero el periodo de consideracion
        }*/
        return new ResponseEntity<>(psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6"), HttpStatus.OK);
    }
}
