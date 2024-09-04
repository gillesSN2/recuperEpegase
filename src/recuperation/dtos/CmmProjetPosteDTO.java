package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class CmmProjetPosteDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long proposId;

    private String proposCode;

    private String proposLibelleFr;

    private String proposLibelleUk;

    private String proposLibelleSp;

    private Long proId;

}
