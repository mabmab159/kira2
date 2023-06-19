package britanico.kira.Utils;

import britanico.kira.ModelsAux.ClaseRecomendada;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

public class ClaseRecomendadaResponse {
    private HashMap<Integer, LVF_CLASE> LVF_CLASE = new HashMap<>();
    private HashMap<Integer, MODELO_REUNION> modeloReunionHashMap = new HashMap<>();
    private HashMap<Integer, DIAS> integerDIASHashMap = new HashMap<>();

    public ClaseRecomendadaResponse(List<ClaseRecomendada> cl) {
        //Mapeamos todos los objetos en los HashMap
        for (ClaseRecomendada c : cl) {
            setLvfClase(c);
            LVF_CLASE lvfClase = LVF_CLASE.get(c.NRO_CLASE);
            if (modeloReunionHashMap.containsKey(c.NRO_CLASE)) {
                lvfClase.MODELO_REUNION.add(modeloReunionHashMap.get(c.NRO_CLASE));
                lvfClase.DIAS.add(integerDIASHashMap.get(c.NRO_CLASE));
                LVF_CLASE.put(c.NRO_CLASE, lvfClase);
            }
        }
    }

    public List<britanico.kira.Utils.LVF_CLASE> getLVF_CLASE() {
        return new ArrayList<>(LVF_CLASE.values());
    }

    public void setLvfClase(ClaseRecomendada c) {
        LVF_CLASE lvfClase = new LVF_CLASE(c.NRO_CLASE, c.DESCR_CLASE, c.DESCR_CURSO, c.SECCION_CLASE, c.CICLO_LECTIVO,
                c.SESION, c.VACANTES, c.PRECIO, new ArrayList<>(), new ArrayList<>());
        MODELO_REUNION modeloReunion = new MODELO_REUNION(c.NRO_CLASE, c.AULA, c.COD_HORA, null, null, null, null, null,
                null, null);
        DIAS dias = new DIAS(c.NRO_CLASE, c.MON, c.TUES, c.WED, c.THURS, c.FRI, c.SAT, c.SUN);
        modeloReunionHashMap.put(c.NRO_CLASE, modeloReunion);
        integerDIASHashMap.put(c.NRO_CLASE, dias);
        LVF_CLASE.put(c.NRO_CLASE, lvfClase);
    }
}

@AllArgsConstructor
class LVF_CLASE {
    public Integer NRO_CLASE;
    public String DESCR_CLASE;
    public String DESCR_CURSO;
    public String SECCION_CLASE;
    public String CICLO_LECTIVO;
    public String SESION;
    public Short VACANTES;
    public BigDecimal PRECIO;
    public List<MODELO_REUNION> MODELO_REUNION;
    public List<DIAS> DIAS;
}

@AllArgsConstructor
class MODELO_REUNION {
    private Integer NRO_CLASE;
    public String COD_HORA;
    public String DESC_HORA;
    public String AULA;
    public String COD_UBI;
    public String DESC_UBI;
    public String COD_FREC;
    public String DESC_FREC;
    public String DOCENTE;
    public String FECHAS_CLASE;
}

@AllArgsConstructor
class DIAS {
    private Integer NRO_CLASE;
    public Character MON;
    public Character TUES;
    public Character WED;
    public Character THURS;
    public Character FRI;
    public Character SAT;
    public Character SUN;
}