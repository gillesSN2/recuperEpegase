package recuperation.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class GroupesModulesesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long groupesId;

    private String modulesesCode;

}
