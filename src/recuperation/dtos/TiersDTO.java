package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class TiersDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long tieid;

    private String createdBy;

    private LocalDateTime createdDate;

    private Boolean deleted;

    private String lastModifiedBy;

    private LocalDateTime lastModifiedDate;

    private Long id;

    private String tietecAdresse;

    private Integer tietecEtat;

    private String tietecLogin;

    private String tietecPs;

    private String tietecService;

    private Integer tietecType;

    private Long tieId;

}
