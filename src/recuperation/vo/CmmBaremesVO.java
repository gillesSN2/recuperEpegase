package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
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
public class CmmBaremesVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "barId can not null")
    private Long barId;


    /**
     * date de creation
     */
    private LocalDateTime barDateCreat;


    /**
     * date de modification
     */
    private LocalDateTime barDateModif;


    /**
     * utilisateur de creation
     */
    private Long barUserCreat;


    /**
     * utilisateur de modification
     */
    private Long barUserModif;


    /**
     * code bareme
     */
    private String barCode;


    /**
     * nom bareme en FR
     */
    private String barNomFr;


    /**
     * nom bareme en UK
     */
    private String barNomUk;


    /**
     * nom bareme en SP
     */
    private String barNomSp;


    /**
     * 0=actif 1=inactif 2=supprimer
     */
    private Integer barInactif;


    /**
     * 0=remise tiers 1=remise produit
     */
    private Integer barOptions;


    /**
     * 0=tiers 1=famille tiers 2=produit 3=famille produit
     */
    private Integer barType;


    /**
     * id du tiers
     */
    private Long barIdTiers;


    /**
     * nom du tiers
     */
    private String barNomTiers;


    /**
     * code produit
     */
    private String barCodeProduit;


    /**
     * nom produit
     */
    private String barLibelleProduit;


    /**
     * code famille vente
     */
    private String barCodeVte;


    /**
     * libelle famille vente
     */
    private String barLibelleVte;


    /**
     * date de debut de validite
     */
    private LocalDate barDateDebut;


    /**
     * annee de fin de validite
     */
    private LocalDate barDateFin;


    /**
     * remise
     */
    private Float barRemise;


    /**
     * rabais
     */
    private Double barRabais;


    /**
     * prix force
     */
    private Double barPrix;

}
