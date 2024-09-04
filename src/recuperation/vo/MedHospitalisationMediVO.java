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
public class MedHospitalisationMediVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "hosmedId can not null")
    private Long hosmedId;


    /**
     * id medecin
     */
    private Long hosmedIdMedecin;


    /**
     * nom medecin
     */
    private String hosmedMedecin;


    /**
     * service
     */
    private String hosmedService;


    /**
     * code produit
     */
    private String hosmedProduit;


    /**
     * libelle produit
     */
    private String hosmedLibelle;


    /**
     * prix unitaire
     */
    private Double hosmedPu;


    /**
     * code de tva
     */
    private String hosmedCodeTva;


    /**
     * taux de tva
     */
    private Float hosmedTauxTva;


    /**
     * %remise
     */
    private Float hosmedRemise;


    /**
     * prix apres remise
     */
    private Double hosmedPuRem;


    /**
     * code depot de stockage
     */
    private String hosmedDepot;


    /**
     * quantite
     */
    private Float hosmedQte;


    /**
     * part ht patient
     */
    private Double hosmedPatientHt;


    /**
     * part taxe patient
     */
    private Double hosmedPatientTaxe;


    /**
     * part ht societe
     */
    private Double hosmedSocieteHt;


    /**
     * part taxe societe
     */
    private Double hosmedSocieteTaxe;


    /**
     * part ht assurance
     */
    private Double hosmedAssuranceHt;


    /**
     * part taxe assurance
     */
    private Double hosmedAssuranceTaxe;


    /**
     * part ht comllementaire
     */
    private Double hosmedComplementaireHt;


    /**
     * part taxe complementaire
     */
    private Double hosmedComplementaireTaxe;


    /**
     * total ht
     */
    private Double hosmedTotal;


    /**
     * total taxe
     */
    private Double hosmedTaxe;


    /**
     * id sejour
     */
    private Long hosmedIdSejour;

    @NotNull(message = "hosId can not null")
    private Long hosId;


    /**
     * famille produit
     */
    private String hosmedFamille;


    /**
     * pump
     */
    private Double hosmedPump;


    /**
     * quantite en stock
     */
    private Float hosmedStock;

}
