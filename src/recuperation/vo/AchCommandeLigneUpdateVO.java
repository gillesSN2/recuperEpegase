package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class AchCommandeLigneUpdateVO extends AchCommandeLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
