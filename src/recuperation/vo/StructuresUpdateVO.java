package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class StructuresUpdateVO extends StructuresVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
