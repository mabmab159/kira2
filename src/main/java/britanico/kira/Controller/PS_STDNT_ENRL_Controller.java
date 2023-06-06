package britanico.kira.Controller;

import britanico.kira.ModelsAux.UltimaClaseAprobada;
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

    @Autowired
    public PS_STDNT_ENRL_Controller(PS_STDNT_ENRL_Service psStdntEnrlService) {
        this.psStdntEnrlService = psStdntEnrlService;
    }

    @GetMapping("/test/{institution}/{emplid}")
    public ResponseEntity<Object> obtenerRecomendacion(@PathVariable("institution") String institution,
                                                       @PathVariable("emplid") String emplid) {
        UltimaClaseAprobada ultimaClaseAprobada = psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6");
        LocalDate fechaActual = LocalDate.now();
        if (ultimaClaseAprobada.FEC_MAX.after(
                Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            //Validar sesion actual
            System.out.println(fechaActual.getMonthValue());
            String sesionRecomendar =
                    (char) (fechaActual.getMonthValue() + 64) + ultimaClaseAprobada.SESSION_CODE.substring(1);
            //Considerar flujo para validar la proxima clase
            System.out.println("Estamos dentro del plazo: " + sesionRecomendar);
        } else {
            System.out.println("" + Calendar.MONTH);
            //No existe curso para recomendar
            System.out.println("Ya vencio");
        }
        return new ResponseEntity<>(psStdntEnrlService.ultimaClaseAprobada(institution, emplid, "6"), HttpStatus.OK);
    }
}