package britanico.kira.Controller;

import britanico.kira.ModelsAux.Salida;
import britanico.kira.ModelsAux.UltimaClaseAprobada;
import britanico.kira.Services.PS_CLASS_TBL_Service;
import britanico.kira.Services.PS_LVF_PARAM_GENER_Service;
import britanico.kira.Services.PS_STDNT_ENRL_Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

@RestController
@RequestMapping("/clase")
public class ClaseController {

    public PS_STDNT_ENRL_Service psStdntEnrlService;
    public PS_CLASS_TBL_Service psClassTblService;
    public PS_LVF_PARAM_GENER_Service psLvfParamGenerService;

    public ClaseController(PS_STDNT_ENRL_Service psStdntEnrlService, PS_CLASS_TBL_Service psClassTblService, PS_LVF_PARAM_GENER_Service psLvfParamGenerService) {
        this.psStdntEnrlService = psStdntEnrlService;
        this.psClassTblService = psClassTblService;
        this.psLvfParamGenerService = psLvfParamGenerService;
    }

    @GetMapping("/claseRecomendada/{emplid}")
    public ResponseEntity<Object> obtenerRecomendacion(@PathVariable("emplid") String emplid) {
        String mesesContinuidad = psLvfParamGenerService.obtenerCantidadMesesContinuidad();
        LocalDate fechaActual = LocalDate.now();
        UltimaClaseAprobada ultimaClaseAprobada = psStdntEnrlService.ultimaClaseAprobada(emplid, mesesContinuidad);
        if (ultimaClaseAprobada.FEC_MAX.after(Date.from(fechaActual.atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            String sesionRecomendar = (char) (fechaActual.getMonthValue() + 64) + ultimaClaseAprobada.SESSION_CODE.substring(1);
            return new ResponseEntity<>(Salida.builder().body(Salida.Body.builder().data(psClassTblService.clasesRecomendadas(String.valueOf(fechaActual.getYear()), sesionRecomendar, ultimaClaseAprobada.CRSE_ID, ultimaClaseAprobada.STND_MTG_PAT)).build()).build(), HttpStatus.OK);
        }
        return new ResponseEntity<>(Salida.builder().body(Salida.Body.builder().data(new ArrayList<>()).build()).build(), HttpStatus.OK);
    }
}