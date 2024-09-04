package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class FamilleClientUpdateVO extends FamilleClientVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
