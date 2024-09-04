package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class ModulesQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String code;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String active;

    private String description;

    private String iconClass;

    private String libelle;

    private Integer ordre;

    private Long structureId;

    private String url;

    private String version;

    private String versionDate;

}
