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
public class VteTaxesVentesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "taxvteId can not null")
    private Long taxvteId;


    /**
     * date de creation
     */
    private LocalDateTime taxvteDateCreation;


    /**
     * date de modification
     */
    private LocalDateTime taxvteDateModif;


    /**
     * user de creation
     */
    private Long taxvteUserCreation;


    /**
     * user de modification
     */
    private Long taxvteUserModif;


    /**
     * code de la taxe
     */
    private String taxvteCode;


    /**
     * libelle de la taxe FR
     */
    private String taxvteLibelleFr;


    /**
     * libelle de la taxe UK
     */
    private String taxvteLibelleUk;


    /**
     * libelle de la taxe SP
     */
    private String taxvteLibelleSp;


    /**
     * taux de la taxe
     */
    private Float taxvteTaux;


    /**
     * numero de compte
     */
    private String taxvteCompte;


    /**
     * 0=tva sur biens 1=tva sur prestations 2=brs sur prestations
     */
    private Integer taxvteType;


    /**
     * 0=sans timbre 1=timbre paye par le client 2=timbre non paye par le client
     */
    private Integer taxvteTimbre;


    /**
     * 0=sans taxe complementaire 1=avec centimes additionnels 2=avec taxe egalisation
     */
    private Integer taxvteTc;


    /**
     * 1=inactif 2=supprimer
     */
    private Integer taxvteInactif;

    @NotNull(message = "exevteId can not null")
    private Long exevteId;

}
