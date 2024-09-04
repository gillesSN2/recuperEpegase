package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class McfDossierDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long dosId;

    private LocalDate dosDateDemande;

    private LocalDate dosDateReception;

    private LocalDate dosDateAcceptation;

    private LocalDate dosDateRefus;

    private String dosMotifRefus;

    private Integer dosType;

    private LocalDate dosDateCloture;

    private String dosMotifCloture;

    private Long tieId;

}
