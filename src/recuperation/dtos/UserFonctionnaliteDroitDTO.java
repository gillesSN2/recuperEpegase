package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class UserFonctionnaliteDroitDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Boolean creation;

    private Boolean edition;

    private Boolean impression;

    private Boolean lecture;

    private Long structureId;

    private Boolean suppression;

    private Boolean transfertComptabilite;

    private String fonctionnaliteCode;

    private Long utilisateurId;

}
