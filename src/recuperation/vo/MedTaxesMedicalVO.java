package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotNull")};
        {stringHelper.

getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotBlank")};{stringHelper.getJakartaEEClassNameOrNot($ {
    useJakartaEE
},"NotEmpty")};


@Data
public class MedTaxesMedicalVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "taxmedId can not null")
    private Long taxmedId;


    /**
     * date de creation
     */
    private LocalDateTime taxmedDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime taxmedDateModif;


    /**
     * user de creation
     */
    private Long taxmedUserCreation;


    /**
     * user de modification
     */
    private Long taxmedUserModif;


    /**
     * code de la taxe
     */
    private String taxmedCode;


    /**
     * libelle de la taxe FR
     */
    private String taxmedLibelleFr;


    /**
     * libelle de la taxe UK
     */
    private String taxmedLibelleUk;


    /**
     * libelle de la taxe SP
     */
    private String taxmedLibelleSp;


    /**
     * taux de la taxe
     */
    private Float taxmedTaux;


    /**
     * numero de compte
     */
    private String taxmedCompte;


    /**
     * 0=tva sur biens 1=tva sur prestations 2=brs sur prestations
     */
    private Integer taxmedType;


    /**
     * 0=sans timbre 1=timbre paye par le fournisseur 2=timbre non payee par le fournisseur
     */
    private Integer taxmedTimbre;


    /**
     * 0=sans taxe complementaire 1=avec centimes additionnels 2=avec taxe egalisation
     */
    private Integer taxmedTc;


    /**
     * 1=inactif 2=supprimer
     */
    private Integer taxmedInactif;

    @NotNull(message = "exemedId can not null")
    private Long exemedId;

    private Long exevteId;

}
