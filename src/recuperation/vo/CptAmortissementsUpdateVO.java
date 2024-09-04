package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CptAmortissementsUpdateVO extends CptAmortissementsVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
