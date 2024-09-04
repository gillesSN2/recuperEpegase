package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class DevisesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String format;

    private String libelle;

    private Long structureId;

    private Float taux1;

    private Float taux2;

}
