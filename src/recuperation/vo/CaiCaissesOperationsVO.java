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
public class CaiCaissesOperationsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "caiopeId can not null")
    private Long caiopeId;


    /**
     * date de creation
     */
    private LocalDateTime caiopeDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime caiopeDateModif;


    /**
     * utilisateur de creation
     */
    private Long caiopeUserCreat;


    /**
     * utilisateur de modification
     */
    private Long caiopeUserModif;


    /**
     * code caisse
     */
    private String caiopeCode;


    /**
     * nom de la caisse
     */
    private String caiopeNom;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer caiopeInactif;


    /**
     * 0=entrees 1=sorties
     */
    private Integer caiopeType;


    /**
     * 0=transferable 1=non transferable
     */
    private Integer caiopeTransfert;


    /**
     * 0=client 1=fournisseur 2=personnel 3=mouvement
     */
    private Integer caiopeCategorie;

    @NotNull(message = "execaiId can not null")
    private Long execaiId;

}
