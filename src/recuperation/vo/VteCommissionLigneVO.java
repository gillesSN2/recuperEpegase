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
public class VteCommissionLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "comligId can not null")
    private Long comligId;


    /**
     * date du document
     */
    private LocalDateTime comligDate;


    /**
     * date du dernier reglement
     */
    private LocalDateTime comligDateLastReg;


    /**
     * nb jour
     */
    private Long comligNbJour;


    /**
     * numero document
     */
    private String comligNum;


    /**
     * nature document
     */
    private Integer comligNature;


    /**
     * nom du commercial
     */
    private String comligNomResponsable;


    /**
     * id du commercial
     */
    private Long comligIdResponsable;


    /**
     * nom du commercial
     */
    private String comligNomCommercial;


    /**
     * id du commercial
     */
    private Long comligIdCommercial;


    /**
     * nom du client
     */
    private String comligNomTiers;


    /**
     * id du tiers
     */
    private Long comligIdTiers;


    /**
     * civilite du tiers
     */
    private String comligCivilTiers;


    /**
     * id du contact
     */
    private Long comligIdContact;


    /**
     * nom du contact
     */
    private String comligNomContact;


    /**
     * civilite du contact
     */
    private String comligCivilContact;


    /**
     * serie
     */
    private String comligSerie;


    /**
     * categorie du client
     */
    private String comligCat;


    /**
     * code devise
     */
    private String comligDevise;


    /**
     * id ligne de document
     */
    private Long comligIdLigne;


    /**
     * code produit
     */
    private String comligCode;


    /**
     * libelle produit
     */
    private String comligLibelle;


    /**
     * total qte produit
     */
    private Float comligQte;


    /**
     * total ht
     */
    private Double comligTotHt;


    /**
     * commission unitaire
     */
    private Double comligComUnite;


    /**
     * % de commission
     */
    private Float comligComPourcentage;


    /**
     * total commission
     */
    private Double comligTotCommission;

    @NotNull(message = "comId can not null")
    private Long comId;


    /**
     * nom du equipe
     */
    private String comligNomEquipe;


    /**
     * id du equipe
     */
    private Long comligIdEquipe;

}
