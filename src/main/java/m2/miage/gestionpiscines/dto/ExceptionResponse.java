package m2.miage.gestionpiscines.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExceptionResponse {
    private Integer codeErreur;
    private String messageErreur;
}
