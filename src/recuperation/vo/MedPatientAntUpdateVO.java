package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class MedPatientAntUpdateVO extends MedPatientAntVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
