package recuperation.vo;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class FamillesFournisseursQueryVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private Boolean active;

    private Boolean avecDouane;

    private Boolean avecTva;

    private String code;

    private String description;

    private Boolean exonarationDouane;

    private Boolean exonarationTaxe;

    private String journal;

    private String libelle;

    private Boolean precompte;

}
