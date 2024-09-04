package com.yewi.yewicore.recuperation.vo;

import $;
import lombok.Data;

import java.io.Serializable;

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
public class MedPharmacieLigneVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "phaligId can not null")
    private Long phaligId;


    /**
     * code produit
     */
    private String phaligProduit;


    /**
     * depot
     */
    private String phaligDepot;


    /**
     * code de la tva
     */
    private String phaligCodeTva;


    /**
     * code lettre
     */
    private String phaligLettre;


    /**
     * nombre lettre
     */
    private Float phaligNb;


    /**
     * valeur lettre
     */
    private Double phaligValeur;


    /**
     * prix unitaire
     */
    private Double phaligPu;


    /**
     * taux de tva
     */
    private Float phaligTauxTva;


    /**
     * %remise
     */
    private Float phaligRemise;


    /**
     * prix apres remise
     */
    private Float phaligPuRem;


    /**
     * quantite
     */
    private Float phaligQte;


    /**
     * part ht patient
     */
    private Double phaligPatientHt;


    /**
     * part taxe patient
     */
    private Double phaligPatientTaxe;


    /**
     * part ht societe
     */
    private Double phaligSocieteHt;


    /**
     * part taxe societe
     */
    private Double phaligSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double phaligAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double phaligAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double phaligComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double phaligComplementaireTaxe;


    /**
     * total ht
     */
    private Double phaligTotal;

    @NotNull(message = "phaId can not null")
    private Long phaId;


    /**
     * libelle produit
     */
    private String phaligLibelle;


    /**
     * dci
     */
    private String phaligDci;


    /**
     * famille produit
     */
    private String phaligFamille;


    /**
     * unite produit
     */
    private String phaligUnite;


    /**
     * conditionnement produit
     */
    private String phaligCondition;


    /**
     * description conditionnement produit
     */
    private String phaligDescription;


    /**
     * mode de gestion de stock
     */
    private Integer phaligStock;


    /**
     * echelle de la ligne
     */
    private Integer phaligEchelle;


    /**
     * total taxe
     */
    private Double phaligTaxe;


    /**
     * pump
     */
    private Double phaligPump;

}
