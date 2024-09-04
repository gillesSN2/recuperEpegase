package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class PayMissionsUpdateVO extends PayMissionsVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
