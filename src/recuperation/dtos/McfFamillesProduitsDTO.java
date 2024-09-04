package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class McfFamillesProduitsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long fammcfI;

    private LocalDate fammcfDateCreation;

    private LocalDate fammcfDateModif;

    private Long fammcfUserCreation;

    private Long fammcfUserModif;

    private String fammcfCode;

    private String fammcfLibelleFr;

    private String fammcfLibelleUk;

    private String fammcfLibelleSp;

    private String fammcfTaxe;

    private String fammcfCompteLocal;

    private String fammcfCompteZone;

    private String fammcfCompteExterieur;

    private Integer fammcfNature;

    private String fammcfLibNature;

    private Integer fammcfInactif;

    private Long exemcfId;

}
