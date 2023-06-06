package britanico.kira.Models;


import jakarta.persistence.*;
import org.springframework.validation.ObjectError;

@NamedNativeQueries(@NamedNativeQuery(
        name = "", query = "", resultSetMapping = ""
))
@SqlResultSetMappings(
        @SqlResultSetMapping(
                name = "", classes = @ConstructorResult(targetClass = Object.class, columns =
                {
                        @ColumnResult(name = "sad")
                })
        )
)
public class PS_CLASS_TBL {
}
