package recuperation.vo;


import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class SitesUpdateVO extends SitesVO implements Serializable {
    private static final long serialVersionUID = 1L;

}
