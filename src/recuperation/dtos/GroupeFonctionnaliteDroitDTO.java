package recuperation.dtos;


import lombok.Data;

import java.io.Serializable;

@Data
public class GroupeFonctionnaliteDroitDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String codeFonctionnalite;

    private Long idGroupe;

    private Boolean creation;

    private Boolean edition;

    private Boolean impression;

    private Boolean lecture;

    private Long structureId;

    private Boolean suppression;

    private Boolean transfertComptabilite;

}
