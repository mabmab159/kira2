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
import java.util.List;

@RestController
public class PS_STDNT_ENRL_Controller {

    public PS_STDNT_ENRL_Service psStdntEnrlService;
    public PS_CLASS_TBL_Service psClassTblService;

    @Autowired
    public PS_STDNT_ENRL_Controller(PS_STDNT_ENRL_Service psStdntEnrlService
            , PS_CLASS_TBL_Service psClassTblService
    ) {
        this.psStdntEnrlService = psStdntEnrlService;
        this.psClassTblService = psClassTblService;
    }


    @GetMapping("/test/{institution}/{emplid}")
    public ResponseEntity<Object> obtenerRecomendacion(@PathVariable("institution") String institution, @PathVariable("emplid") String emplid) {
        UltimaClaseAprobada ultimaClaseAprobada = psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6");
        LocalDate fechaActual = LocalDate.now();
        if (ultimaClaseAprobada.FEC_MAX.after(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            String sesionRecomendar = (char) (fechaActual.getMonthValue() + 64) + ultimaClaseAprobada.SESSION_CODE.substring(1);
            List<ClaseRecomendada> claseRecomendadasList = psClassTblService.clasesRecomendadas("2023", "FOW",
                    "210009", "2130");
            claseRecomendadasList.forEach(p -> System.out.println((Object) p.PRECIO.getClass()));
            return new ResponseEntity<>(psClassTblService.clasesRecomendadas("2023", "FOW",
                    "210009", "2130"), HttpStatus.OK);
        } else {
            System.out.println("" + Calendar.MONTH);
            System.out.println("Ya vencio");
        }
        return new ResponseEntity<>(psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6"), HttpStatus.OK);
    }
}
