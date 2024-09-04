package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class GroupesModulesesDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long groupesId;

    private String modulesesCode;

}
