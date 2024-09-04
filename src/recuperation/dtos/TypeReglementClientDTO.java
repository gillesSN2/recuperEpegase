package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TypeReglementClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private String libelle;

    private Boolean used;

}
