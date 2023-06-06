package britanico.kira.ModelsAux;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salida {
    public Body body;
    public final int success = 1;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Body {
        public Object data;
        public final String message = "ok";
    }

}
