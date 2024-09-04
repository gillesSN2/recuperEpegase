package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class ImmBienFactureUpdateVO extends ImmBienFactureVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
