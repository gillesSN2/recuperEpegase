package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SecteursQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String code;

    private String nom;

    private String responsable;

    private Long structureId;

    private Long zoneId;

}
