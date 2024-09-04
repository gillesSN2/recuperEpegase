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
public class AchFraisTheoAchatsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "fstId can not null")
    private Long fstId;


    /**
     * date de creation
     */
    private LocalDateTime fstDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime fstDateModif;


    /**
     * utilisateur de creation
     */
    private Long fstUserCreat;


    /**
     * utilisateur de modification
     */
    private Long fstUserModif;


    /**
     * nom de la feuille
     */
    private String fstFeuille;


    /**
     * type de la feuille
     */
    private Integer fstType;


    /**
     * code frais
     */
    private String fstCode;


    /**
     * nom frais en FR
     */
    private String fstNomFr;


    /**
     * nom frais en UK
     */
    private String fstNomUk;


    /**
     * nom frais en SP
     */
    private String fstNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer fstInactif;


    /**
     * annee de debut de validite
     */
    private Float fstTaux;


    /**
     * formule
     */
    private String fstFormule;


    /**
     * ordre de la ligne
     */
    private Integer fstOrdre;


    /**
     * autorise dans la colonne ht
     */
    private Boolean fstColHt;


    /**
     * autorise dans la colonne exo partielle
     */
    private Boolean fstColExop;


    /**
     * autorise dans la colonne exo totale
     */
    private Boolean fstColExot;


    /**
     * 0=standard 1=prc 2=prg
     */
    private Integer fstColType;

}
