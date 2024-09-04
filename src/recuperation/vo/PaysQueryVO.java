package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class PaysQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String devise;

    private String drapeau;

    private String fiscalite;

    private Integer gestion;

    private String indicatif;

    private String iso;

    private String langue;

    private String nationnalite;

    private String nom;

    private String zone;

}
