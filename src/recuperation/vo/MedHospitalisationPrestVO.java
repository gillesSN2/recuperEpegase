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
public class MedHospitalisationPrestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "hosprtId can not null")
    private Long hosprtId;


    /**
     * id medecin
     */
    private Long hosprtIdMedecin;


    /**
     * nom medecin
     */
    private String hosprtMedecin;


    /**
     * service
     */
    private String hosprtService;


    /**
     * code produit
     */
    private String hosprtProduit;


    /**
     * libelle produit
     */
    private String hosprtLibelle;


    /**
     * code lettre
     */
    private String hosprtLettre;


    /**
     * nombre lettre
     */
    private Float hosprtNb;


    /**
     * valeur lettre
     */
    private Double hosprtValeur;


    /**
     * coefficient
     */
    private Float hosprtCoef;


    /**
     * prix unitaire
     */
    private Double hosprtPu;


    /**
     * code de tva
     */
    private String hosprtCodeTva;


    /**
     * taux de tva
     */
    private Float hosprtTauxTva;


    /**
     * %remise
     */
    private Float hosprtRemise;


    /**
     * prix apres remise
     */
    private Double hosprtPuRem;


    /**
     * quantite
     */
    private Float hosprtQte;


    /**
     * part ht patient
     */
    private Double hosprtPatientHt;


    /**
     * part taxe patient
     */
    private Double hosprtPatientTaxe;


    /**
     * part ht societe
     */
    private Double hosprtSocieteHt;


    /**
     * part taxe societe
     */
    private Double hosprtSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double hosprtAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double hosprtAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double hosprtComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double hosprtComplementaireTaxe;


    /**
     * total ht
     */
    private Double hosprtTotal;


    /**
     * total taxe
     */
    private Double hosprtTaxe;


    /**
     * id sejour
     */
    private Long hosprtIdSejour;

    @NotNull(message = "hosId can not null")
    private Long hosId;

}
